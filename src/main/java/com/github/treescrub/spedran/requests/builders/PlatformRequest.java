package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Platform;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Platform}.
 */
public class PlatformRequest extends SingleResourceRequest<Platform> {
    public PlatformRequest(String id) {
        super(HttpMethod.GET, "platforms/{id}", Map.of("id", id));
    }

    public PlatformRequest(Platform platform) {
        this(platform.getId());
    }

    @Override
    protected Class<Platform> getDataClass() {
        return Platform.class;
    }
}
