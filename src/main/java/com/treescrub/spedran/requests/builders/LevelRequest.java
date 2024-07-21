package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Level}.
 */
public class LevelRequest extends SingleResourceRequest<Level> {
    @SuppressWarnings("unused")
    public LevelRequest(String id) {
        super(HttpMethod.GET, "levels/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public LevelRequest(Level level) {
        this(level.getId());
    }

    @Override
    protected Class<Level> getDataClass() {
        return Level.class;
    }
}
