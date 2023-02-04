package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.leaderboard.Leaderboard;
import treescrub.spedran.data.run.TimingType;

import java.util.Map;

public class LeaderboardRequest extends SingleResourceRequest<Leaderboard> {
    public LeaderboardRequest(String game, String category) {
        super(HttpMethod.GET, "leaderboards/{game}/category/{category}", Map.of("game", game, "category", category));
    }

    public LeaderboardRequest(String game, String category, String level) {
        super(HttpMethod.GET, "leaderboards/{game}/level/{level}/{category}", Map.of("game", game, "category", category, "level", level));
    }

    public LeaderboardRequest top(int topPlaces) {
        setParameter("top", topPlaces);
        return this;
    }

    public LeaderboardRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public LeaderboardRequest region(String id) {
        setParameter("region", id);
        return this;
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

    @Override
    protected Leaderboard parse(JSONObject data) {
        return new Leaderboard(data);
    }
}
