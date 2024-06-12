package com.github.treescrub.spedran.data.leaderboard;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.data.Resource;
import com.github.treescrub.spedran.data.run.TimingType;

import java.util.*;

/**
 * A collection of runs sorted by ranking as they would appear on SRC.
 * Does not contain obsoleted runs.
 */
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
        values = Collections.unmodifiableMap(values);
        runs = new ArrayList<>();
        for(Object object : data.getJSONArray("runs")) {
            JSONObject runData = (JSONObject) object;
            runs.add(new LeaderboardRun(runData));
        }
        runs = Collections.unmodifiableList(runs);
    }

    /**
     * Gets the link to this leaderboard on SRC.
     * <br><b>SRC API currently returns a link that does not work!</b>
     *
     * @return a link to the leaderboard on SRC
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     * Gets the game ID for this leaderboard.
     *
     * @return the game ID
     *
     * @see com.github.treescrub.spedran.api.Spedran#getGame(String)
     * @see com.github.treescrub.spedran.data.game.Game
     */
    public String getGame() {
        return game;
    }

    /**
     * Gets the category ID for this leaderboard.
     *
     * @return the category ID
     *
     * @see com.github.treescrub.spedran.api.Spedran#getCategory(String)
     * @see com.github.treescrub.spedran.data.category.Category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the level ID as an {@link Optional}.
     *
     * @return an {@link Optional} containing the level ID, empty if no level was provided
     *
     * @see com.github.treescrub.spedran.api.Spedran#getLevel(String)
     * @see com.github.treescrub.spedran.data.Level
     */
    public Optional<String> getLevel() {
        return Optional.ofNullable(level);
    }

    /**
     * Gets the platform ID as an {@link Optional}.
     *
     * @return an {@link Optional} containing the platform ID, empty if no platform was provided
     *
     * @see com.github.treescrub.spedran.api.Spedran#getPlatform(String)
     * @see com.github.treescrub.spedran.data.Platform
     */
    public Optional<String> getPlatform() {
        return Optional.ofNullable(platform);
    }

    /**
     * Gets the region ID as an {@link Optional}.
     *
     * @return an {@link Optional} with the region ID, empty if no region was provided
     *
     * @see com.github.treescrub.spedran.api.Spedran#getRegion(String)
     * @see com.github.treescrub.spedran.data.Region
     */
    public Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }

    /**
     * Gets whether runs using an emulator were filtered out.
     *
     * @return {@code false} if runs using an emulator were filtered out, otherwise {@code true}
     */
    public Boolean getEmulators() {
        return emulators;
    }

    /**
     * If runs with no video were filtered out, returns {@code true}, otherwise {@code false}.
     *
     * @return {@code true} if the 'videos only' filter was set, otherwise {@code false}
     */
    public boolean isVideoOnly() {
        return videoOnly;
    }

    /**
     * Gets the {@code TimingType} that was used to sort the runs from {@link Leaderboard#getRuns()}.
     *
     * @return the {@code TimingType} that the runs were sorted by
     *
     * @see com.github.treescrub.spedran.data.run.TimingType
     */
    public TimingType getTiming() {
        return timing;
    }

    /**
     * Gets a mapping of variable IDs to variable value IDs.
     *
     * @return a {@code Map} with keys being variable IDs and values being variable values
     *
     * @see com.github.treescrub.spedran.data.variables.Variable
     */
    public Map<String, String> getValues() {
        return values;
    }

    /**
     * Gets all runs on the leaderboard.
     * Runs are sorted by place on the leaderboard.
     *
     * @return a {@code List} with all runs on this leaderboard
     *
     * @see com.github.treescrub.spedran.data.leaderboard.LeaderboardRun
     */
    public List<LeaderboardRun> getRuns() {
        return runs;
    }
}
