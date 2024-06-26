package com.github.treescrub.spedran.requests.builders.platform;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.Platform;

import java.util.Map;

public class PlatformRequest extends SingleResourceRequest<Platform> {
    public PlatformRequest(String id) {
        super(HttpMethod.GET, "platforms/{id}", Map.of("id", id));
    }

    public PlatformRequest(Platform platform) {
        this(platform.getId());
    }

    @Override
    protected Platform parse(JSONObject data) {
        return new Platform(data);
    }
}
