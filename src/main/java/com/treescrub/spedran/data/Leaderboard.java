package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import kong.unirest.json.JSONObject;

import java.util.*;

/**
 * A collection of runs sorted by ranking as they would appear on SRC.
 * Does not contain obsoleted runs.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Leaderboard extends Resource {
    private final String weblink;
    private final EmbeddableResource<Game> game;
    private final EmbeddableResource<Category> category;
    private final EmbeddableResource<Level> level;
    private final String platform;
    private final String region;
    private final Boolean emulators;
    private final boolean videoOnly;
    private final TimingType timing;
    private final Map<String, String> values;
    private final List<LeaderboardRun> runs;
    private final List<Platform> platforms;
    private final List<Player> players;
    private final List<Region> regions;
    private final List<Variable> variables;

    Leaderboard(JSONObject data) {
        super(data);

        weblink = data.getString("weblink");
        game = ParseUtils.getEmbeddableResource(data, "game", Game::new);
        category = ParseUtils.getEmbeddableResource(data, "category", Category::new);
        level = ParseUtils.getEmbeddableResource(data, "level", Level::new);
        platform = data.isNull("platform") ? null : data.getString("platform");
        region = data.isNull("region") ? null : data.getString("region");
        emulators = data.isNull("emulators") ? null : data.getBoolean("emulators");
        videoOnly = data.getBoolean("video-only");
        timing = data.isNull("timing") ? null : TimingType.valueOf(data.getString("timing").toUpperCase());
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
        platforms = ParseUtils.getEmbeddedResourceList(data, "platforms", Platform::new);
        players = ParseUtils.getEmbeddedResourceList(data, "players", Player::new);
        regions = ParseUtils.getEmbeddedResourceList(data, "regions", Region::new);
        variables = ParseUtils.getEmbeddedResourceList(data, "variables", Variable::new);
    }

    /**
     * Gets the link to this leaderboard on SRC.
     * <br><b>SRC API currently returns a link that does not work!</b>
     *
     * @return a link to the leaderboard on SRC
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    public EmbeddableResource<Game> getGame() {
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
    @SuppressWarnings("unused")
    public EmbeddableResource<Category> getCategory() {
        return category;
    }

    /**
     * Gets the level ID as an {@link Optional}.
     *
     * @return an {@link Optional} containing the level ID, empty if no level was provided
     *
     * @see Spedran#getLevel(String)
     * @see Level
     */
    @SuppressWarnings("unused")
    public Optional<EmbeddableResource<Level>> getLevel() {
        return Optional.ofNullable(level);
    }

    /**
     * Gets the platform ID as an {@link Optional}.
     *
     * @return an {@link Optional} containing the platform ID, empty if no platform was provided
     *
     * @see Spedran#getPlatform(String)
     * @see Platform
     */
    @SuppressWarnings("unused")
    public Optional<String> getPlatform() {
        return Optional.ofNullable(platform);
    }

    /**
     * Gets a {@code List} of platforms used in this leaderboard as an {@link Optional}.
     *
     * @return an {@link Optional} containing the platforms, empty if not embedded
     *
     * @see Platform
     */
    public Optional<List<Platform>> getPlatforms() {
        return Optional.ofNullable(platforms);
    }

    /**
     * Gets the region ID as an {@link Optional}.
     *
     * @return an {@link Optional} with the region ID, empty if no region was provided
     *
     * @see Spedran#getRegion(String)
     * @see Region
     */
    @SuppressWarnings("unused")
    public Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }

    /**
     * Gets a {@code List} of regions used in this leaderboard as an {@link Optional}.
     *
     * @return an {@link Optional} containing the regions, empty if not embedded
     *
     * @see Region
     */
    public Optional<List<Region>> getRegions() {
        return Optional.ofNullable(regions);
    }

    /**
     * Gets whether runs using an emulator were filtered out.
     *
     * @return {@code false} if runs using an emulator were filtered out, otherwise {@code true}
     */
    @SuppressWarnings("unused")
    public Optional<Boolean> getEmulators() {
        return Optional.ofNullable(emulators);
    }

    /**
     * If runs with no video were filtered out, returns {@code true}, otherwise {@code false}.
     *
     * @return {@code true} if the 'videos only' filter was set, otherwise {@code false}
     */
    @SuppressWarnings("unused")
    public boolean isVideoOnly() {
        return videoOnly;
    }

    /**
     * Gets the {@code TimingType} that was used to sort the runs from {@link Leaderboard#getRuns()}.
     *
     * @return the {@code TimingType} that the runs were sorted by, empty if not specified
     *
     * @see TimingType
     */
    @SuppressWarnings("unused")
    public Optional<TimingType> getTiming() {
        return Optional.ofNullable(timing);
    }

    /**
     * Gets a mapping of variable IDs to variable value IDs.
     *
     * @return an unmodifiable {@code Map} with keys being variable IDs and values being variable values
     *
     * @see Variable
     */
    @SuppressWarnings("unused")
    public Map<String, String> getValues() {
        return values;
    }

    /**
     * Gets all runs on the leaderboard.
     * Runs are sorted by place on the leaderboard.
     *
     * @return an unmodifiable {@code List} with all runs on this leaderboard
     *
     * @see LeaderboardRun
     */
    @SuppressWarnings("unused")
    public List<LeaderboardRun> getRuns() {
        return runs;
    }

    /**
     * Gets a {@code List} of variables applicable to this leaderboard as an {@link Optional}.
     *
     * @return an {@link Optional} containing the applicable variables, empty if not embedded
     *
     * @see Variable
     */
    public Optional<List<Variable>> getVariables() {
        return Optional.ofNullable(variables);
    }

    /**
     * Gets a {@code List} of all players in this leaderboard as an {@link Optional}.
     *
     * @return an {@link Optional} containing the players, empty if not embedded
     *
     * @see Platform
     */
    public Optional<List<Player>> getPlayers() {
        return Optional.ofNullable(players);
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
