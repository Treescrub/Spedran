package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Engine;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Engine}.
 */
public class EngineRequest extends SingleResourceRequest<Engine> {
    @SuppressWarnings("unused")
    public EngineRequest(String id) {
        super(HttpMethod.GET, "engines/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public EngineRequest(Engine engine) {
        this(engine.getId());
    }

    @Override
    protected Class<Engine> getDataClass() {
        return Engine.class;
    }
}
