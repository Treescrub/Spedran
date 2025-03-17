package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Publisher;
import com.treescrub.spedran.data.Region;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Region}.
 */
public class RegionRequest extends SingleResourceRequest<Region> {
    @SuppressWarnings("unused")
    protected RegionRequest(String id) {
        super(HttpMethod.GET, "regions/{id}", Map.of("id", id));
    }

    public static RegionRequest create(Region region) {
        checkResource(region, "region");

        return new RegionRequest(region.getId());
    }

    public static RegionRequest create(String id) {
        checkId(id);

        return new RegionRequest(id);
    }

    @Override
    protected Class<Region> getDataClass() {
        return Region.class;
    }
}
