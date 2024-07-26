package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Region;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Region}.
 */
public class RegionRequest extends SingleResourceRequest<Region> {
    @SuppressWarnings("unused")
    public RegionRequest(String id) {
        super(HttpMethod.GET, "regions/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public RegionRequest(Region region) {
        this(region.getId());
    }

    @Override
    protected Class<Region> getDataClass() {
        return Region.class;
    }
}
