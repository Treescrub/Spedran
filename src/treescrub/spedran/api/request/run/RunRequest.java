package treescrub.spedran.api.request.run;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.run.Run;

import java.util.Map;

public class RunRequest extends SingleResourceRequest<Run> {
    public RunRequest(String id) {
        super(HttpMethod.GET, "runs/{id}", Map.of("id", id));
    }

    public RunRequest(Run run) {
        this(run.getId());
    }

    @Override
    protected Run parse(JSONObject data) {
        return new Run(data);
    }
}
