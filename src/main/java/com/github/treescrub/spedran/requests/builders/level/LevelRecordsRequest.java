package com.github.treescrub.spedran.requests.builders.level;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.leaderboard.Leaderboard;

import java.util.Map;
import java.util.function.Function;

public class LevelRecordsRequest extends ResourceCollectionRequest<Leaderboard> {
    public LevelRecordsRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/records", Map.of("id", id));
    }

    public LevelRecordsRequest(Level level) {
        this(level.getId());
    }

    public LevelRecordsRequest top(int topPlaces) {
        setParameter("top", topPlaces);
        return this;
    }

    public LevelRecordsRequest skipEmptyResults() {
        setParameter("skip-empty", true);
        return this;
    }

    public LevelRecordsRequest keepEmptyResults() {
        setParameter("skip-empty", false);
        return this;
    }

    @Override
    protected Function<JSONObject, Leaderboard> getConstructor() {
        return Leaderboard::new;
    }
}
