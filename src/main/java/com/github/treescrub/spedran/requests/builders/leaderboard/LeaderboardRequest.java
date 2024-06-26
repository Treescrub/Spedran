package com.github.treescrub.spedran.requests.builders.leaderboard;

import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.Platform;
import com.github.treescrub.spedran.data.Region;
import com.github.treescrub.spedran.data.Category;
import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.data.Leaderboard;
import com.github.treescrub.spedran.data.TimingType;
import com.github.treescrub.spedran.data.Variable;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class LeaderboardRequest extends SingleResourceRequest<Leaderboard> {
    public LeaderboardRequest(String game, String category) {
        super(HttpMethod.GET, "leaderboards/{game}/category/{category}", Map.of("game", game, "category", category));
    }

    public LeaderboardRequest(String game, String category, String level) {
        super(HttpMethod.GET, "leaderboards/{game}/level/{level}/{category}", Map.of("game", game, "category", category, "level", level));
    }

    public LeaderboardRequest(Game game, Category category) {
        this(game.getId(), category.getId());
    }

    public LeaderboardRequest(Game game, Category category, Level level) {
        this(game.getId(), category.getId(), level.getId());
    }

    public LeaderboardRequest top(int topPlaces) {
        setParameter("top", topPlaces);
        return this;
    }

    public LeaderboardRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public LeaderboardRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    public LeaderboardRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    public LeaderboardRequest region(Region region) {
        return region(region.getId());
    }

    public LeaderboardRequest onlyEmulators() {
        setParameter("emulators", true);
        return this;
    }

    public LeaderboardRequest onlyRealDevices() {
        setParameter("emulators", false);
        return this;
    }

    public LeaderboardRequest videosOnly() {
        setParameter("video-only", true);
        return this;
    }

    public LeaderboardRequest timing(TimingType timingType) {
        setParameter("timing", timingType.name().toLowerCase());
        return this;
    }

    public LeaderboardRequest beforeDate(String date) {
        setParameter("date", date);
        return this;
    }

    public LeaderboardRequest variable(String id, String value) {
        setParameter("var-" + id, value);
        return this;
    }

    public LeaderboardRequest variable(Variable variable, String valueId) {
        return variable(variable.getId(), valueId);
    }

    @Override
    protected Class<Leaderboard> getDataClass() {
        return Leaderboard.class;
    }
}
