package treescrub.spedran.cache;

import treescrub.spedran.data.IdentifiableResource;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private static final long DEFAULT_INVALIDATION_TIME_SECONDS = 60;
    private static Duration invalidationTime = Duration.ofSeconds(DEFAULT_INVALIDATION_TIME_SECONDS);
    private static Map<String, CacheEntry> entries = new ConcurrentHashMap<>();

    public IdentifiableResource getResource(String id) {
        if(isEntryValid(id)) {
            return entries.get(id).getResource();
        } else {
            // add entry
            return null; // return new resource
        }
    }

    private boolean hasEntry(String id) {
        return entries.containsKey(id);
    }

    private boolean isEntryValid(String id) {
        if(!hasEntry(id))
            return false;

        CacheEntry entry = entries.get(id);
        return Instant.now().isBefore(entry.getAccessTime().plus(invalidationTime));
    }
}
