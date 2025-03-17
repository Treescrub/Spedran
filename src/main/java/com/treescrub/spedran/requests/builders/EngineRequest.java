package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Engine;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Engine}.
 */
public class EngineRequest extends SingleResourceRequest<Engine> {
    @SuppressWarnings("unused")
    protected EngineRequest(String id) {
        super(HttpMethod.GET, "engines/{id}", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code EngineRequest} builder.
     *
     * @param engine the engine to get
     * @return a {@code EngineRequest} builder
     */
    public static EngineRequest create(Engine engine) {
        checkResource(engine, "engine");

        return new EngineRequest(engine.getId());
    }

    /**
     * Creates and returns a new {@code EngineRequest} builder.
     *
     * @param id the engine to get
     * @return a {@code EngineRequest} builder
     */
    public static EngineRequest create(String id) {
        checkId(id);

        return new EngineRequest(id);
    }

    @Override
    protected Class<Engine> getDataClass() {
        return Engine.class;
    }
}
