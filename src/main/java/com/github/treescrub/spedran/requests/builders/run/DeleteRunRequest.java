package com.github.treescrub.spedran.requests.builders.run;

import com.github.treescrub.spedran.data.run.Run;
import com.github.treescrub.spedran.requests.ModifyResourceRequest;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONElement;

import java.util.Map;

public class DeleteRunRequest extends ModifyResourceRequest<Run> {
    public DeleteRunRequest(String id) {
        super(HttpMethod.DELETE, "runs/{id}", Map.of("id", id));
    }

    public DeleteRunRequest(Run run) {
        this(run.getId());
    }

    @Override
    protected Class<Run> getDataClass() {
        return Run.class;
    }

    @Override
    protected JSONElement buildBody() {
        return null;
    }
}