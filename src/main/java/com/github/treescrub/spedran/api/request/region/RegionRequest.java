package com.github.treescrub.spedran.api.request.region;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.api.request.SingleResourceRequest;
import com.github.treescrub.spedran.data.Region;

import java.util.Map;

public class RegionRequest extends SingleResourceRequest<Region> {
    public RegionRequest(String id) {
        super(HttpMethod.GET, "regions/{id}", Map.of("id", id));
    }

    public RegionRequest(Region region) {
        this(region.getId());
    }

    @Override
    protected Region parse(JSONObject data) {
        return new Region(data);
    }
}
