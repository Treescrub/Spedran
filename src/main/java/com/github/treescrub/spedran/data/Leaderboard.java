package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import kong.unirest.json.JSONObject;

import java.util.*;

/**
 * A collection of runs sorted by ranking as they would appear on SRC.
 * Does not contain obsoleted runs.
 */
public class Leaderboard extends Resource {
    private final String weblink;
    private final String game;
    private final String category;
    private final String level;
    private final String platform;
    private final String region;
    private final Boolean emulators;
    private final boolean videoOnly;
    private final TimingType timing;
    private final Map<String, String> values;
    private final List<LeaderboardRun> runs;

    Leaderboard(JSONObject data) {
        super(data);

        weblink = data.getString("weblink");
        game = data.getString("game");
        category = data.getString("category");
        level = data.isNull("level") ? null : data.getString("level");
        platform = data.isNull("platform") ? null : data.getString("platform");
        region = data.isNull("region") ? null : data.getString("region");
        emulators = data.isNull("emulators") ? null : data.getBoolean("emulators");
        videoOnly = data.getBoolean("video-only");
        timing = TimingType.valueOf(data.getString("timing").toUpperCase());
        Map<String, String> tempValues = new HashMap<>();
        for(String key : data.getJSONObject("values").keySet()) {
            tempValues.put(key, data.getString(key));
        }
        values = Collections.unmodifiableMap(tempValues);
        List<LeaderboardRun> tempRuns = new ArrayList<>();
        for(Object object : data.getJSONArray("runs")) {
            JSONObject runData = (JSONObject) object;
            tempRuns.add(new LeaderboardRun(runData));
        }
        runs = Collections.unmodifiableList(tempRuns);
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
     * @see Spedran#getGame(String)
     * @see Game
     */
    public String getGame() {
        return game;
    }

    /**
     * Gets the category ID for this leaderboard.
     *
     * @return the category ID
     *
     * @see Spedran#getCategory(String)
     * @see Category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the level ID as an {@link Optional}.
     *
     * @return an {@link Optional} containing the level ID, empty if no level was provided
     *
     * @see Spedran#getLevel(String)
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
     * @see Spedran#getPlatform(String)
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
     * @see Spedran#getRegion(String)
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
    public Optional<Boolean> getEmulators() {
        return Optional.ofNullable(emulators);
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
     * @see TimingType
     */
    public TimingType getTiming() {
        return timing;
    }

    /**
     * Gets a mapping of variable IDs to variable value IDs.
     *
     * @return a {@code Map} with keys being variable IDs and values being variable values
     *
     * @see Variable
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
     * @see LeaderboardRun
     */
    public List<LeaderboardRun> getRuns() {
        return runs;
    }

    @Override
    public String toString() {
        return "Leaderboard{" +
                "game='" + game + '\'' +
                ", category='" + category + '\'' +
                ", level='" + level + '\'' +
                "}";
    }
}
