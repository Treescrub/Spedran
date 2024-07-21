package com.treescrub.spedran.requests;

import kong.unirest.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class RequestCache {
    private static class CacheEntry {
        final long timestamp;
        final HttpResponse<?> response;

        @SuppressWarnings("unused")
        CacheEntry(long timestamp, HttpResponse<?> response) {
            this.timestamp = timestamp;
            this.response = response;
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(RequestCache.class);
    private volatile long cacheTimeLimitMs = 1000L;
    private volatile boolean disabled = false;
    private final Map<String, CacheEntry> cachedRequests;

    @SuppressWarnings("unused")
    RequestCache() {
        cachedRequests = new ConcurrentHashMap<>();
    }

    Optional<HttpResponse<?>> getCachedResponse(String url) {
        if(disabled) {
            return Optional.empty();
        }

        CacheEntry entry = cachedRequests.get(url);

        if(entry == null) {
            return Optional.empty();
        }

        long currentTimestamp = System.currentTimeMillis();

        if(entry.timestamp > currentTimestamp || currentTimestamp - entry.timestamp >= cacheTimeLimitMs) {
            // Remove this entry from the cache.
            cachedRequests.remove(url);

            logger.debug("Removing '{}' from cache", url);

            return Optional.empty();
        }

        return Optional.ofNullable(entry.response);
    }

    void addResponse(String url, HttpResponse<?> response) {
        if(disabled) {
            return;
        }

        logger.debug("Adding '{}' to cache", url);
        cachedRequests.put(url, new CacheEntry(System.currentTimeMillis(), response));
    }

    /**
     * Sets the time limit in milliseconds before an entry is considered invalid.
     */
    void setTimeLimit(long timeLimit) {
        cacheTimeLimitMs = timeLimit;
    }

    void enable() {
        this.disabled = false;
    }

    void disable() {
        this.disabled = true;

        cachedRequests.clear();
    }
}
