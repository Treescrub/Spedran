package com.treescrub.spedran;

import kong.unirest.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Main request configuration and state.
 */
class Requests {
    private static class RequestThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {
        private final AtomicInteger count = new AtomicInteger(0);

        @Override
        public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
            ForkJoinWorkerThread newThread = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
            newThread.setName("Spedran ForkJoin-" + count.getAndIncrement());

            return newThread;
        }
    }

    static final String BASE_URL = "https://www.speedrun.com/api/v1/";
    static final ForkJoinPool forkJoinPool = new ForkJoinPool(ForkJoinPool.getCommonPoolParallelism(), new RequestThreadFactory(), null, true);

    private static String key;
    private static UnirestInstance unirestInstance;
    private static final RequestCache cache = new RequestCache();
    private static final RequestQueue queue = new RequestQueue();
    private static final Logger logger = LoggerFactory.getLogger(Requests.class);

    static {
        setup();
    }

    private Requests() {}

    private static void setup() {
        String version = "UNKNOWN";
        try {
            Properties properties = new Properties();
            properties.load(Requests.class.getClassLoader().getResourceAsStream("spedran.properties"));
            version = properties.getProperty("version");
        } catch (IOException e) {
            logger.warn("Failed to load version", e);
        }

        logger.info("Got version '{}' from properties", version);

        unirestInstance = Unirest.spawnInstance();
        unirestInstance.config().addDefaultHeader("User-Agent", "Spedran/" + version);
        unirestInstance.config().defaultBaseUrl(BASE_URL);
        unirestInstance.config().interceptor(new LoggingInterceptor());
    }

    static HttpRequestWithBody request(HttpMethod method, String url) {
        HttpRequestWithBody httpRequest = unirestInstance.request(method.name(), url);
        if(key != null) {
            httpRequest.header("X-Api-Key", key);
        }

        return httpRequest;
    }

    static void sendRequest(ResourceRequest<?> request) {
        queue.queueRequest(request);
    }

    static void setKey(String newKey) {
        key = newKey;
    }

    static void clearKey() {
        key = null;
    }

    static Optional<HttpResponse<?>> getCachedResponse(String url) {
        return cache.getCachedResponse(url);
    }

    static void addCachedResponse(String url, HttpResponse<?> response) {
        cache.addResponse(url, response);
    }

    /**
     * Shuts down background threads.
     */
    static void shutDown() {
        logger.info("Shutting Spedran down...");
        unirestInstance.shutDown();
        queue.shutDown();
    }

    /**
     * Enable request caching.
     */
    static void enableCache() {
        cache.enable();

        logger.info("Enabling request cache");
    }

    /**
     * Disable request caching.
     */
    static void disableCache() {
        cache.disable();

        logger.info("Disabling request cache");
    }

    /**
     * Sets the maximum time that entries are considered valid in the request cache.
     *
     * @param newTimeLimit the new time limit in milliseconds
     */
    static void setCacheTimeLimit(long newTimeLimit) {
        cache.setTimeLimit(newTimeLimit);

        logger.info("Setting request cache time limit to {}ms", newTimeLimit);
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
    static void setBackoffValues(double base, long reduceDelay, double constant) {
        logger.info("Setting custom backoff values: base={}, reduceDelay={}, constant={}", base, reduceDelay, constant);

        queue.setBackoff(base, reduceDelay, constant);
    }
}
