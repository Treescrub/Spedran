package com.github.treescrub.spedran.requests;

import kong.unirest.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class RequestCache {
    static class CacheEntry {
        long timestamp;
        HttpResponse<?> response;

        CacheEntry(long timestamp, HttpResponse<?> response) {
            this.timestamp = timestamp;
            this.response = response;
        }
    }

    private static final Logger logger = LogManager.getLogger(RequestCache.class);
    private static final long CACHE_TIME_LIMIT_MS = 1000L;
    private final Map<String, CacheEntry> cachedRequests;

    RequestCache() {
        cachedRequests = new ConcurrentHashMap<>();
    }

    Optional<HttpResponse<?>> getCachedResponse(String url) {
        CacheEntry entry = cachedRequests.get(url);

        if(entry == null) {
            return Optional.empty();
        }

        long currentTimestamp = System.currentTimeMillis();

        if(entry.timestamp > currentTimestamp || currentTimestamp - entry.timestamp >= CACHE_TIME_LIMIT_MS) {
            // Remove this entry from the cache.
            cachedRequests.remove(url);

            logger.debug("Removing '{}' from cache", url);

            return Optional.empty();
        }

        return Optional.ofNullable(entry.response);
    }

    void addResponse(String url, HttpResponse<?> response) {
        logger.debug("Adding '{}' to cache", url);
        cachedRequests.put(url, new CacheEntry(System.currentTimeMillis(), response));
    }
}
