package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.data.Platform;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Platform}.
 */
public class PlatformRequest extends SingleResourceRequest<Platform> {
    @SuppressWarnings("unused")
    protected PlatformRequest(String id) {
        super(HttpMethod.GET, "platforms/{id}", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code PlatformRequest} builder.
     *
     * @param platform the platform to get
     * @return a {@code PlatformRequest} builder
     */
    public static PlatformRequest create(Platform platform) {
        checkResource(platform, "platform");

        return new PlatformRequest(platform.getId());
    }

    /**
     * Creates and returns a new {@code PlatformRequest} builder.
     *
     * @param id the platform to get
     * @return a {@code PlatformRequest} builder
     */
    public static PlatformRequest create(String id) {
        checkId(id);

        return new PlatformRequest(id);
    }

    @Override
    protected Class<Platform> getDataClass() {
        return Platform.class;
    }
}
