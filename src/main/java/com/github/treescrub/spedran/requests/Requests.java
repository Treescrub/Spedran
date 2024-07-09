package com.github.treescrub.spedran.requests;

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
public class Requests {
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
            properties.load(Requests.class.getClassLoader().getResourceAsStream("project.properties"));
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

    public static void setKey(String newKey) {
        key = newKey;
    }

    public static void clearKey() {
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
    public static void shutDown() {
        unirestInstance.shutDown();
        queue.shutDown();
    }

    /**
     * Enable request caching.
     */
    public static void enableCache() {
        cache.enable();

        logger.debug("Enabling request cache");
    }

    /**
     * Disable request caching.
     */
    public static void disableCache() {
        cache.disable();

        logger.debug("Disabling request cache");
    }

    /**
     * Sets the maximum time that entries are considered valid in the request cache.
     *
     * @param newTimeLimit the new time limit in milliseconds
     */
    public static void setCacheTimeLimit(long newTimeLimit) {
        cache.setTimeLimit(newTimeLimit);

        logger.debug("Setting request cache time limit to {}ms", newTimeLimit);
    }
}
