package com.github.treescrub.spedran.api.request.run;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.api.request.SingleResourceRequest;
import com.github.treescrub.spedran.data.run.Run;

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
