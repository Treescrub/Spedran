package com.github.treescrub.spedran.requests.builders.run;

import com.github.treescrub.spedran.data.Run;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
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
