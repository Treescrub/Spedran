package com.github.treescrub.spedran.api.request.run;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.api.request.SingleResourceRequest;
import com.github.treescrub.spedran.data.run.Run;

import java.util.Map;

public class DeleteRunRequest extends SingleResourceRequest<Run> {
    public DeleteRunRequest(String id, String apiKey) {
        super(HttpMethod.DELETE, "runs/{id}", Map.of("id", id));

        request.header("X-API-Key", apiKey);
    }

    public DeleteRunRequest(Run run, String apiKey) {
        this(run.getId(), apiKey);
    }

    @Override
    protected Run parse(JSONObject data) {
        return new Run(data);
    }
}
