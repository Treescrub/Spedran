package treescrub.spedran.api.request.run;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;

import java.util.Map;

public class RunStatusRequest extends SingleResourceRequest<Void> {
    public RunStatusRequest(String id) {
        super(HttpMethod.PUT, "runs/{id}/status", Map.of("id", id));
    }

    // TODO: authentication, run status serialization

    @Override
    protected Void parse(JSONObject data) {
        return null;
    }
}
