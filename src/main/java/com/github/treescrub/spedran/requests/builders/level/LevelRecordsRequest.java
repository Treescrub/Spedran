package com.github.treescrub.spedran.requests.builders.level;

import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.Leaderboard;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

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
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
