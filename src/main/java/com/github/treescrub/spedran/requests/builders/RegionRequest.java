package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Region;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class RegionRequest extends SingleResourceRequest<Region> {
    public RegionRequest(String id) {
        super(HttpMethod.GET, "regions/{id}", Map.of("id", id));
    }

    public RegionRequest(Region region) {
        this(region.getId());
    }

    @Override
    protected Class<Region> getDataClass() {
        return Region.class;
    }
}
