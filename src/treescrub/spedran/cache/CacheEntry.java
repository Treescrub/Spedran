package treescrub.spedran.cache;

import treescrub.spedran.data.IdentifiableResource;

import java.time.Instant;

public class CacheEntry {
    private Instant accessTime;
    private IdentifiableResource resource;

    public CacheEntry(IdentifiableResource resource) {
        this(Instant.now(), resource);
    }

    public CacheEntry(Instant accessTime, IdentifiableResource resource) {
        this.accessTime = accessTime;
        this.resource = resource;
    }

    public Instant getAccessTime() {
        return accessTime;
    }

    public IdentifiableResource getResource() {
        return resource;
    }
}
