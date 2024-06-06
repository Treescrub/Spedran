package com.github.treescrub.spedran.api.request.run;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.api.request.SingleResourceRequest;
import com.github.treescrub.spedran.data.run.Run;

import java.util.Map;

public class RunStatusRequest extends SingleResourceRequest<Void> {
    public RunStatusRequest(String id) {
        super(HttpMethod.PUT, "runs/{id}/status", Map.of("id", id));
    }

    public RunStatusRequest(Run run) {
        this(run.getId());
    }

    // TODO: authentication, run status serialization

    @Override
    protected Void parse(JSONObject data) {
        return null;
    }
}
