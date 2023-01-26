package treescrub.spedran.data.leaderboard;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Level;
import treescrub.spedran.data.Platform;
import treescrub.spedran.data.Region;
import treescrub.spedran.data.Resource;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.run.TimingType;

import java.util.*;

public class Leaderboard extends Resource {
    private String weblink;
    private Game game;
    private Category category;
    private Level level;
    private Platform platform;
    private Region region;
    private Boolean emulators;
    private boolean videoOnly;
    private TimingType timing;
    private Map<String, String> values;
    private List<LeaderboardRun> runs;

    public Leaderboard(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Leaderboard(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        weblink = data.getString("weblink");
        game = new Game(data.getString("game"));
        category = new Category(data.getString("category"));
        level = data.isNull("level") ? null : new Level(data.getString("level"));
        platform = data.isNull("platform") ? null : new Platform(data.getString("platform"));
        region = data.isNull("region") ? null : new Region(data.getString("region"));
        emulators = data.isNull("emulators") ? null : data.getBoolean("emulators");
        videoOnly = data.getBoolean("video-only");
        timing = TimingType.valueOf(data.getString("timing").toUpperCase());
        values = new HashMap<>();
        for(String key : data.getJSONObject("values").keySet()) {
            values.put(key, data.getString(key));
        }
        runs = new ArrayList<>();
        for(Object object : data.getJSONArray("runs")) {
            JSONObject runData = (JSONObject) object;
            runs.add(new LeaderboardRun(runData));
        }
    }

    public String getWeblink() {
        return weblink;
    }

    public Game getGame() {
        return game;
    }

    public Category getCategory() {
        return category;
    }

    public Optional<Level> getLevel() {
        return Optional.ofNullable(level);
    }

    public Optional<Platform> getPlatform() {
        return Optional.ofNullable(platform);
    }

    public Optional<Region> getRegion() {
        return Optional.ofNullable(region);
    }

    public Boolean getEmulators() {
        return emulators;
    }

    public boolean isVideoOnly() {
        return videoOnly;
    }

    public TimingType getTiming() {
        return timing;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public List<LeaderboardRun> getRuns() {
        return runs;
    }
}
