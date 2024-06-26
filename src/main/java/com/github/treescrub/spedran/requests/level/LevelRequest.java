package com.github.treescrub.spedran.requests.level;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import com.github.treescrub.spedran.data.Level;

import java.util.Map;

public class LevelRequest extends SingleResourceRequest<Level> {
    public LevelRequest(String id) {
        super(HttpMethod.GET, "levels/{id}", Map.of("id", id));
    }

    public LevelRequest(Level level) {
        this(level.getId());
    }

    @Override
    protected Level parse(JSONObject data) {
        return new Level(data);
    }
}
