package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.run.Run;

import java.util.Map;

public class RunPlayersRequest extends SingleResourceRequest<Run> {
    public RunPlayersRequest(String id) {
        super(HttpMethod.PUT, "runs/{id}/players", Map.of("id", id));
    }

    // TODO: authentication, run players serialization

    @Override
    protected Run parse(JSONObject data) {
        return new Run(data);
    }
}
