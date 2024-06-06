package com.github.treescrub.spedran.requests;

import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.treescrub.spedran.api.request.ResourceRequest;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {
    private static final Queue<ResourceRequest<?>> requestQueue = new ConcurrentLinkedQueue<>();
    /**
     * Number of times we recently encountered a rate limit.
     * Decremented on successful request if we haven't hit a rate limit recently.
     */
    private static final AtomicInteger rateLimitCount = new AtomicInteger(0);
    /**
     * HTTP status code used to indicate throttling/rate limiting.
     */
    private static final int RATELIMIT_CODE = 420;
    /**
     * The base of the exponent for exponential backoff.
     */
    private static final double BACKOFF_EXPONENT_BASE = 2.0;
    /**
     * Time between rate limited requests before exponential backoff is reduced.
     * In milliseconds.
     */
    private static final long BACKOFF_REDUCE_DELAY_MS = 30 * 1000;
    /**
     * Constant to multiply backoff time by in order to offset initial delay.
     */
    private static final double BACKOFF_OFFSET_CONSTANT = 0.5;

    private static long lastRateLimit = 0;

    private static final ExecutorService queueExecutor = Executors.newSingleThreadExecutor();
    private static final Logger logger = LogManager.getLogger();

    public static void queueRequest(ResourceRequest<?> request) {
        requestQueue.add(request);

        logger.debug("Request {} submitted to queue", request.getRequest().toSummary().asString());

        queueExecutor.submit(RequestQueue::executeUntilEmpty);
    }

    /**
     * Execute all requests in the queue until the queue is empty.
     */
    private static void executeUntilEmpty() {
        ResourceRequest<?> currentRequest = requestQueue.peek();

        while(currentRequest != null) {
            if(shouldRateLimit()) {
                logger.debug("Sleeping for {}ms because of rate limit", getRateLimitDelay());

                try {
                    Thread.sleep(getRateLimitDelay());
                } catch (InterruptedException e) {
                    logger.warn("Interrupted while sleeping for rate limit", e);
                }
            }

            executeRequest(currentRequest);

            // If all API requests for the current request are finished, remove from queue
            if(currentRequest.isCompleted()) {
                requestQueue.remove();
            }
            currentRequest = requestQueue.peek();
        }
    }

    /**
     * Execute the next request and check the result.
     */
    private static void executeRequest(ResourceRequest<?> resourceRequest) {
        HttpRequest<?> httpRequest = resourceRequest.getRequest();
        // Execute the blocking resource request and get the response from the API.
        HttpResponse<?> response = resourceRequest.executeBlocking();

        if(response.isSuccess()) {
            long millisecondsSinceLastRateLimit = System.currentTimeMillis() - lastRateLimit;

            // Reduce the delay because it's been a while since we hit a rate limit
            if(millisecondsSinceLastRateLimit >= BACKOFF_REDUCE_DELAY_MS) {
                synchronized (rateLimitCount) {
                    if (rateLimitCount.get() > 0) {
                        logger.debug("Reducing rate limit delay");
                        rateLimitCount.decrementAndGet();
                    }
                }

                lastRateLimit = System.currentTimeMillis();
            }

            resourceRequest.finishRequest(response.getBody());
        } else {
            if(response.getStatus() == RATELIMIT_CODE) {
                // Add the request back to the end of the queue.
                requestQueue.add(resourceRequest);

                rateLimitCount.incrementAndGet();
                lastRateLimit = System.currentTimeMillis();

                logger.debug("Hit rate limit");

                return;
            }

            // Log the error code and fail the request.
            logger.info("Request to '{}' responded with error code {}", httpRequest.getUrl(), response.getStatus());
            resourceRequest.failRequest(new HttpRequestException(response, httpRequest));
            requestQueue.remove();
        }
    }

    /**
     * Should requests be delayed due to hitting a recent rate limit.
     *
     * @return should requests be delayed to prevent hitting rate limit
     */
    private static boolean shouldRateLimit() {
        return rateLimitCount.get() > 0;
    }

    /**
     * Returns the time to wait in milliseconds before attempting another request.
     *
     * @return delay in milliseconds
     */
    private static int getRateLimitDelay() {
        return (int) (Math.pow(BACKOFF_EXPONENT_BASE, rateLimitCount.get() - 1) * 1000 * BACKOFF_OFFSET_CONSTANT);
    }
}
