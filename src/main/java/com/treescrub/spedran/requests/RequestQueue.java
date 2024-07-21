package com.treescrub.spedran.requests;

import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unused")
class RequestQueue {
    private static class QueueThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Spedran RequestQueue Executor");
        }
    }

    private final Queue<ResourceRequest<?>> requestQueue = new ConcurrentLinkedQueue<>();
    /**
     * Number of times we recently encountered a rate limit.
     * Decremented on successful request if we haven't hit a rate limit recently.
     */
    private final AtomicInteger rateLimitCount = new AtomicInteger(0);
    /**
     * Total requests in queue.
     */
    private final AtomicInteger requestsInQueue = new AtomicInteger(0);
    /**
     * HTTP status code used to indicate throttling/rate limiting.
     */
    private static final int RATELIMIT_CODE = 420;
    /**
     * The base of the exponent for exponential backoff.
     */
    private volatile double backoffExponentBase = 2.0;
    /**
     * Time between rate limited requests before exponential backoff is reduced.
     * In milliseconds.
     */
    private volatile long backoffReduceDelayMs = 30 * 1000;
    /**
     * Constant to multiply backoff time by in order to offset initial delay.
     */
    private volatile double backoffOffsetConstant = 0.5;

    private final Object backoffMutex = new Object();

    private volatile long lastRateLimit = 0;
    private final AtomicBoolean isShutDown = new AtomicBoolean(false);

    private final ExecutorService queueExecutor = Executors.newSingleThreadExecutor(new QueueThreadFactory());
    private static final Logger logger = LoggerFactory.getLogger(RequestQueue.class);

    public void queueRequest(ResourceRequest<?> request) {
        if(isShutDown.get()) {
            logger.warn("Request queue is shut down, but a request was submitted");
            return;
        }

        synchronized(requestQueue) {
            requestQueue.add(request);
            requestsInQueue.incrementAndGet();
        }

        logger.debug("Request {} submitted to queue", request.getRequest().getUrl());

        queueExecutor.submit(this::executeUntilEmpty);
    }

    /**
     * Shuts down this request queue.
     * When shut down, requests already in the queue will be executed but new requests won't be accepted.
     */
    public void shutDown() {
        logger.info("Shutting down");

        synchronized(isShutDown) {
            isShutDown.set(true);
            queueExecutor.shutdown();
        }
    }

    /**
     * Execute all requests in the queue until the queue is empty.
     */
    private void executeUntilEmpty() {
        ResourceRequest<?> currentRequest = requestQueue.peek();

        while(currentRequest != null) {
            synchronized(backoffMutex) {
                if(shouldRateLimit()) {
                    logger.debug("Sleeping for {}ms because of rate limit", getRateLimitDelay());

                    try {
                        Thread.sleep(getRateLimitDelay());
                    } catch (InterruptedException e) {
                        logger.warn("Interrupted while sleeping for rate limit", e);
                    }
                }
            }

            executeRequest(currentRequest);

            synchronized(requestQueue) {
                // If all API requests for the current request are finished, remove from queue
                if(currentRequest.isCompleted()) {
                    requestQueue.remove();
                    requestsInQueue.decrementAndGet();

                    logger.debug("Removing '{}' from queue as completed", currentRequest.getRequest().getUrl());
                }

                currentRequest = requestQueue.peek();
            }
        }
    }

    /**
     * Execute the next request and check the result.
     */
    private void executeRequest(ResourceRequest<?> resourceRequest) {
        logger.debug("Executing request to '{}', {} left in queue", resourceRequest.getRequest().getUrl(), requestsInQueue.get());

        HttpRequest<?> httpRequest = resourceRequest.getRequest();
        HttpResponse<?> response;

        Optional<HttpResponse<?>> cachedResponse = Requests.getCachedResponse(httpRequest.getUrl());
        if(cachedResponse.isPresent()) {
            // Skip querying the API and just use the cached response.
            response = cachedResponse.get();
            logger.debug("Using cached response for '{}'", httpRequest.getUrl());
        } else {
            // Execute the blocking resource request and get the response from the API.
            response = resourceRequest.executeBlocking();

            if(response.getStatus() != RATELIMIT_CODE) {
                // Add the fresh response to the cache
                Requests.addCachedResponse(httpRequest.getUrl(), response);
            }
        }

        if(response.isSuccess()) {
            synchronized(backoffMutex) {
                long millisecondsSinceLastRateLimit = System.currentTimeMillis() - lastRateLimit;

                // Reduce the delay because it's been a while since we hit a rate limit
                if(millisecondsSinceLastRateLimit >= backoffReduceDelayMs) {
                    if(rateLimitCount.get() > 0) {
                        logger.debug("Reducing rate limit delay");
                        rateLimitCount.decrementAndGet();
                    }

                    lastRateLimit = System.currentTimeMillis();
                }
            }

            resourceRequest.finishRequest(response.getBody());
        } else {
            if(response.getStatus() == RATELIMIT_CODE) {
                synchronized(backoffMutex) {
                    rateLimitCount.incrementAndGet();
                    lastRateLimit = System.currentTimeMillis();
                }

                logger.debug("Hit rate limit on '{}'", httpRequest.getUrl());

                return;
            }

            // Log the error code and fail the request.
            logger.info("Request to '{}' responded with error code {}", httpRequest.getUrl(), response.getStatus());
            resourceRequest.failRequest(new HttpRequestException(response, httpRequest));
            requestQueue.remove();
        }
    }

    /**
     * Sets the values for exponential backoff.
     * <br>
     * The backoff time is calculated as {@code base^count * constant} where {@code count} is the current rate limit count.
     *
     * @param base the exponent base
     * @param reduceDelay the minimum time in milliseconds before the rate can be increased after hitting a rate limit
     * @param constant a constant factor to multiply the backoff time by
     */
    public void setBackoff(double base, long reduceDelay, double constant) {
        synchronized(backoffMutex) {
            backoffExponentBase = base;
            backoffReduceDelayMs = reduceDelay;
            backoffOffsetConstant = constant;
        }
    }

    /**
     * Should requests be delayed due to hitting a recent rate limit.
     *
     * @return should requests be delayed to prevent hitting rate limit
     */
    private boolean shouldRateLimit() {
        return rateLimitCount.get() > 0;
    }

    /**
     * Returns the time to wait in milliseconds before attempting another request.
     *
     * @return delay in milliseconds
     */
    private int getRateLimitDelay() {
        return (int) (Math.pow(backoffExponentBase, rateLimitCount.get() - 1) * 1000 * backoffOffsetConstant);
    }
}
