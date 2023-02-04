package treescrub.spedran.api.request.engine;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.Engine;

import java.util.Map;

public class EngineRequest extends SingleResourceRequest<Engine> {
    public EngineRequest(String id) {
        super(HttpMethod.GET, "engines/{id}", Map.of("id", id));
    }

    @Override
    protected Engine parse(JSONObject data) {
        return new Engine(data);
    }
}
