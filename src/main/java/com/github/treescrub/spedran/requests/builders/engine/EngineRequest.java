package com.github.treescrub.spedran.requests.builders.engine;

import com.github.treescrub.spedran.data.Engine;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class EngineRequest extends SingleResourceRequest<Engine> {
    public EngineRequest(String id) {
        super(HttpMethod.GET, "engines/{id}", Map.of("id", id));
    }

    public EngineRequest(Engine engine) {
        this(engine.getId());
    }

    @Override
    protected Class<Engine> getDataClass() {
        return Engine.class;
    }
}
