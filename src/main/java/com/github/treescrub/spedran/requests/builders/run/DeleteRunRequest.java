package com.github.treescrub.spedran.requests.builders.run;

import com.github.treescrub.spedran.requests.ModifyResourceRequest;
import com.github.treescrub.spedran.data.run.Run;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONElement;
import kong.unirest.json.JSONObject;

import java.util.Map;

public class DeleteRunRequest extends ModifyResourceRequest<Run> {
    public DeleteRunRequest(String id) {
        super(HttpMethod.DELETE, "runs/{id}", Map.of("id", id));
    }

    public DeleteRunRequest(Run run) {
        this(run.getId());
    }

    @Override
    protected Run parse(JSONObject data) {
        return new Run(data);
    }

    @Override
    protected JSONElement buildBody() {
        return null;
    }
}
