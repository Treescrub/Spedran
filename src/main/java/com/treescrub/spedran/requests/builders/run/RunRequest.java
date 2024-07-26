package com.treescrub.spedran.requests.builders.run;

import com.treescrub.spedran.data.Run;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Run}.
 */
public class RunRequest extends SingleResourceRequest<Run> {
    @SuppressWarnings("unused")
    public RunRequest(String id) {
        super(HttpMethod.GET, "runs/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public RunRequest(Run run) {
        this(run.getId());
    }

    @Override
    protected Class<Run> getDataClass() {
        return Run.class;
    }
}
