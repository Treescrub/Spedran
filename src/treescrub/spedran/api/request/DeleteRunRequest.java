package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.run.Run;

import java.util.Map;

public class DeleteRunRequest extends SingleResourceRequest<Run> {
    public DeleteRunRequest(String id) {
        super(HttpMethod.DELETE, "runs/{id}", Map.of("id", id));
    }

    // TODO: authentication

    @Override
    protected Run parse(JSONObject data) {
        return new Run(data);
    }
}
