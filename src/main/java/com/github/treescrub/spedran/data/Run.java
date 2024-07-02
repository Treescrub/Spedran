package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.builders.run.DeleteRunRequest;
import com.github.treescrub.spedran.requests.builders.run.RunPlayersRequest;
import com.github.treescrub.spedran.requests.builders.run.RunStatusRequest;
import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

/**
 * A speedrun on SRC.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Run extends IdentifiableResource {
    private final String weblink;
    private final String game;
    private final String level;
    private final String category;
    private final RunVideos videos;
    private final String comment;
    private final RunStatus status;
    private final List<RunPlayer> players;
    private final LocalDate date;
    private final Instant submitted;
    private final RunTimes times;
    private final RunSystem system;
    private final Link splits;
    private final Map<String, String> values;

    Run(JSONObject data) {
        super(data);

        weblink = data.getString("weblink");
        game = data.getString("game");
        level = data.optString("level", null);
        category = data.getString("category");
        videos = data.isNull("videos") ? null : new RunVideos(data.getJSONObject("videos"));
        comment = data.optString("comment", null);
        status = new RunStatus(data.getJSONObject("status"));
        List<RunPlayer> tempPlayers = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("players").length(); i++) {
            tempPlayers.add(new RunPlayer(data.getJSONArray("players").getJSONObject(i)));
        }
        players = Collections.unmodifiableList(tempPlayers);
        date = data.isNull("date") ? null : LocalDate.parse(data.getString("date"));
        submitted = data.isNull("submitted") ? null : Instant.parse(data.getString("submitted"));
        times = new RunTimes(data.getJSONObject("times"));
        system = new RunSystem(data.getJSONObject("system"));
        splits = data.isNull("splits") ? null : new Link(data.getJSONObject("splits"));
        Map<String, String> tempValues = new HashMap<>();
        for(String key : data.getJSONObject("values").keySet()) {
            tempValues.put(key, data.getJSONObject("values").getString(key));
        }
        values = Collections.unmodifiableMap(tempValues);
    }

    /**
     * Gets a new {@link DeleteRunRequest} builder to delete this run from SRC.
     * <br>
     * Requires a set API key with sufficient permissions to delete runs, or API key of run owner.
     *
     * @return a {@code DeleteRunRequest} builder
     *
     * @see Spedran#setApiKey(String)
     */
    @SuppressWarnings("unused")
    public DeleteRunRequest delete() {
        return Spedran.deleteRun(id);
    }

    /**
     * Gets a new {@link RunPlayersRequest} builder to set the players on this run.
     * <br>
     * Requires a set API key with sufficient permissions to change the players on this run.
     *
     * @return a {@code RunPlayersRequest} builder
     */
    @SuppressWarnings("unused")
    public RunPlayersRequest setPlayers() {
        return Spedran.setRunPlayers(id);
    }

    /**
     * Gets a new {@link RunStatusRequest} builder to change the status of this run.
     * <br>
     * Requires an API key with sufficient permissions to reject/verify runs.
     *
     * @return a request builder to set the status
     */
    @SuppressWarnings("unused")
    public RunStatusRequest setStatus() {
        return Spedran.setRunStatus(id);
    }

    /**
     * Returns a String containing the URL of the run on SRC.
     *
     * @return a link to the run
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     * Returns a String containing the ID of this run's game.
     *
     * @return the id of the game this run belongs to
     *
     * @see Game
     * @see Spedran#getGame(String)
     */
    public String getGame() {
        return game;
    }

    /**
     * Returns an {@link Optional} String containing the ID of this run's level.
     * If this run has no associated level, returns an empty Optional.
     *
     * @return an {@code Optional} with the ID of this run's level
     *
     * @see com.github.treescrub.spedran.data.Level
     * @see Spedran#getLevel(String)
     */
    public Optional<String> getLevel() {
        return Optional.ofNullable(level);
    }

    /**
     * Returns a String containing the ID of this run's category.
     *
     * @return the ID of this run's category
     *
     * @see Category
     * @see Spedran#getCategory(String)
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets a {@link RunVideos} describing the videos in this run.
     *
     * @return an {@link Optional} with information about this run's videos
     */
    public Optional<RunVideos> getVideos() {
        return Optional.ofNullable(videos);
    }

    /**
     * Gets the description of this run.
     *
     * @return an {@link Optional} with the run comment
     */
    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    /**
     * Gets the current verification status of this run.
     *
     * @return a {@link RunStatus} with verification info
     */
    public RunStatus getStatus() {
        return status;
    }

    /**
     * Gets a {@code List} of the runners of this run.
     *
     * @return a {@code List} of the runners
     */
    public List<RunPlayer> getPlayers() {
        return players;
    }

    /**
     * Returns the {@link LocalDate} that this run was actually ran.
     *
     * @return a {@code LocalDate}
     */
    public Optional<LocalDate> getDateRan() {
        return Optional.ofNullable(date);
    }

    /**
     * Returns the {@link Instant} that this run was submitted to SRC.
     *
     * @return a {@code Instant}
     */
    public Optional<Instant> getSubmitTime() {
        return Optional.ofNullable(submitted);
    }

    /**
     * Gets the times for this run in each timing category.
     *
     * @return a {@link RunTimes} object that has timing info
     */
    public RunTimes getRunTimes() {
        return times;
    }

    /**
     * Gets the system that this run was played on.
     *
     * @return a {@link RunSystem} object that has system info
     */
    public RunSystem getSystem() {
        return system;
    }

    /**
     * Gets a link to the API of a splits hosting site. Currently only supports {@code Splits.io}.
     *
     * @return an {@link Optional} with a {@link Link} that contains info about splits
     */
    public Optional<Link> getSplits() {
        return Optional.ofNullable(splits);
    }

    /**
     * Returns a {@link Map} with each key being a variable ID, and the corresponding value being the variable value ID.
     *
     * @return a {@link Map} between variable IDs and variable value IDs
     */
    public Map<String, String> getVariableValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Run[" + id + "]{" +
                "players=" + players +
                ", status=" + status +
                ", date=" + date +
                ", submitted=" + submitted +
                ", times=" + times +
                "}";
    }
}