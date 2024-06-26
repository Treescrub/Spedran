package com.github.treescrub.spedran.requests.engine;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.Engine;

import java.util.Map;

public class EngineRequest extends SingleResourceRequest<Engine> {
    public EngineRequest(String id) {
        super(HttpMethod.GET, "engines/{id}", Map.of("id", id));
    }

    public EngineRequest(Engine engine) {
        this(engine.getId());
    }

    @Override
    protected Engine parse(JSONObject data) {
        return new Engine(data);
    }
}
