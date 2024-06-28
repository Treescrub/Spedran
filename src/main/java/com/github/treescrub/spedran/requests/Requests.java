package com.github.treescrub.spedran.requests;

import kong.unirest.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

/**
 * Main request configuration and state.
 */
public class Requests {
    static final String BASE_URL = "https://www.speedrun.com/api/v1/";

    private static String key;
    private static UnirestInstance unirestInstance;
    private static final RequestCache cache = new RequestCache();
    private static final RequestQueue queue = new RequestQueue();
    private static final Logger logger = LogManager.getLogger(Requests.class);

    static {
        setup();
    }

    private Requests() {}

    private static void setup() {
        unirestInstance = Unirest.spawnInstance();
        unirestInstance.config().addDefaultHeader("User-Agent", "Spedran/1.0");
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
