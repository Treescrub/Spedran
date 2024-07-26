package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Platform;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Platform}.
 */
public class PlatformRequest extends SingleResourceRequest<Platform> {
    @SuppressWarnings("unused")
    public PlatformRequest(String id) {
        super(HttpMethod.GET, "platforms/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public PlatformRequest(Platform platform) {
        this(platform.getId());
    }

    @Override
    protected Class<Platform> getDataClass() {
        return Platform.class;
    }
}
