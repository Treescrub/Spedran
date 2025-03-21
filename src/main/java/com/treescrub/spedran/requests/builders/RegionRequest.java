package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Region;
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

    /**
     * Creates and returns a new {@code RegionRequest} builder.
     *
     * @param region the region to get
     * @return a {@code RegionRequest} builder
     */
    public static RegionRequest create(Region region) {
        checkResource(region, "region");

        return new RegionRequest(region.getId());
    }

    /**
     * Creates and returns a new {@code RegionRequest} builder.
     *
     * @param id the region to get
     * @return a {@code RegionRequest} builder
     */
    public static RegionRequest create(String id) {
        checkId(id);

        return new RegionRequest(id);
    }

    @Override
    protected Class<Region> getDataClass() {
        return Region.class;
    }
}
