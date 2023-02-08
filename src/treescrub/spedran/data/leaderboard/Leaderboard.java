package treescrub.spedran.data.leaderboard;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Resource;
import treescrub.spedran.data.run.TimingType;

import java.util.*;

public class Leaderboard extends Resource {
    private String weblink;
    private String game;
    private String category;
    private String level;
    private String platform;
    private String region;
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
        game = data.getString("game");
        category = data.getString("category");
        level = data.isNull("level") ? null : data.getString("level");
        platform = data.isNull("platform") ? null : data.getString("platform");
        region = data.isNull("region") ? null : data.getString("region");
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

    public String getGame() {
        return game;
    }

    public String getCategory() {
        return category;
    }

    public Optional<String> getLevel() {
        return Optional.ofNullable(level);
    }

    public Optional<String> getPlatform() {
        return Optional.ofNullable(platform);
    }

    public Optional<String> getRegion() {
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
