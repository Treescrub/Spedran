package treescrub.spedran.requests;

import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import treescrub.spedran.api.request.ResourceRequest;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {
    private static final Queue<ResourceRequest<?>> requestQueue = new ConcurrentLinkedQueue<>();
    /**
     * Times we encountered a ratelimit.
     * Decremented if a request is successful.
     */
    private static final AtomicInteger rateLimitCount = new AtomicInteger(0);
    /**
     * HTTP status code used to indicate throttling/ratelimiting.
     */
    private static final int RATELIMIT_CODE = 420;
    /**
     * The constant used for exponential backoff.
     */
    private static final double BACKOFF_CONSTANT = 2.0;

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

            logger.debug("Sending request for {}", currentRequest);

            executeRequest(currentRequest);

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
        // Execute the blocking resource request and get the response.
        HttpResponse<?> response = resourceRequest.executeBlocking();

        if(response.isSuccess()) {
            synchronized (rateLimitCount) {
                if(rateLimitCount.get() > 0) {
                    rateLimitCount.decrementAndGet();
                }
            }

            resourceRequest.finishRequest(response.getBody());
        } else {
            if(response.getStatus() == RATELIMIT_CODE) {
                // Add the request back to the end of the queue.
                requestQueue.add(resourceRequest);

                rateLimitCount.incrementAndGet();

                logger.info("Hit rate limit");

                return;
            }

            // Log the error code and fail the request.
            logger.info("Request to '{}' responded with error code {}", httpRequest.getUrl(), response.getStatus());
            resourceRequest.failRequest(new Throwable()); // FIXME: use an actual throwable/exception
            requestQueue.remove();
        }
    }

    /**
     * Should requests be delayed due to a rate limit.
     *
     * @return should delay requests
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
        return (int) (Math.pow(BACKOFF_CONSTANT, rateLimitCount.get()) * 1000);
    }
}
