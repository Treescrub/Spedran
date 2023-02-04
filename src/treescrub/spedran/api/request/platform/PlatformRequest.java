package treescrub.spedran.api.request.platform;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Platform;

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
