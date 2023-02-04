package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Platform;

import java.util.Map;

public class PlatformRequest extends SingleResourceRequest<Platform> {
    public PlatformRequest(String id) {
        super(HttpMethod.GET, "platforms/{id}", Map.of("id", id));
    }

    @Override
    protected Platform parse(JSONObject data) {
        return new Platform(data);
    }
}
