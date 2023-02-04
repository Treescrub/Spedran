package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.run.Run;

public class SubmitRunRequest extends SingleResourceRequest<Run> {
    public SubmitRunRequest() {
        super(HttpMethod.POST, "runs");
    }

    // TODO: authentication, run serialization

    @Override
    protected Run parse(JSONObject data) {
        return new Run(data);
    }
}
