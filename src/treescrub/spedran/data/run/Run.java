package treescrub.spedran.data.run;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.run.DeleteRunRequest;
import treescrub.spedran.api.request.run.RunPlayersRequest;
import treescrub.spedran.api.request.run.RunStatusRequest;
import treescrub.spedran.data.IdentifiableResource;
import treescrub.spedran.data.Link;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

/**
 *
 */
public class Run extends IdentifiableResource {
    private String weblink;
    private String game;
    private String level;
    private String category;
    private RunVideos videos;
    private String comment;
    private RunStatus status;
    private List<RunPlayer> players;
    private LocalDate date;
    private Instant submitted;
    private RunTimes times;
    private RunSystem system;
    private Link splits;
    private Map<String, String> values;

    public Run(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Run(JSONObject data) {
        super(data);
    }

    /**
     * Returns a request builder that allows deletion of this run from SRC.
     * Requires an API key with sufficient permissions to delete runs, or API key of run owner.
     *
     * @param apiKey SRC API key
     * @return a request builder to delete this run
     */
    public DeleteRunRequest delete(String apiKey) {
        return new DeleteRunRequest(this, apiKey);
    }

    /**
     * Returns a request builder to set the players on this run.
     *
     * @return a request builder to set players
     */
    public RunPlayersRequest setPlayers() {
        return new RunPlayersRequest(this);
    }

    /**
     * Returns a request builder to change the status of this run.
     * Requires an API key with sufficient permissions to reject/verify runs.
     *
     * @return
     */
    public RunStatusRequest setStatus() {
        return new RunStatusRequest(this);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        weblink = data.getString("weblink");
        game = data.getString("game");
        level = data.optString("level", null);
        category = data.getString("category");
        videos = data.isNull("videos") ? null : new RunVideos(data.getJSONObject("videos"));
        comment = data.optString("comment", null);
        status = new RunStatus(data.getJSONObject("status"));
        players = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("players").length(); i++) {
            players.add(new RunPlayer(data.getJSONArray("players").getJSONObject(i)));
        }
        date = data.isNull("date") ? null : LocalDate.parse(data.getString("date"));
        submitted = data.isNull("submitted") ? null : Instant.parse(data.getString("submitted"));
        times = new RunTimes(data.getJSONObject("times"));
        system = new RunSystem(data.getJSONObject("system"));
        splits = data.isNull("splits") ? null : new Link(data.getJSONObject("splits"));
        values = new HashMap<>();
        for(String key : data.getJSONObject("values").keySet()) {
            values.put(key, data.getJSONObject("values").getString(key));
        }
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
     * @see treescrub.spedran.api.Spedran#getGame(String)
     */
    public String getGame() {
        return game;
    }

    /**
     * Returns an Optional String containing the ID of this run's level.
     * If this run has no associated level, returns an empty Optional.
     *
     * @return an {@link Optional} with the ID of this run's level
     * @see treescrub.spedran.api.Spedran#getLevel(String)
     */
    public Optional<String> getLevel() {
        return Optional.ofNullable(level);
    }

    /**
     * Returns a String containing the ID of this run's category.
     *
     * @return the ID of this run's category
     * @see treescrub.spedran.api.Spedran#getCategory(String)
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     *
     * @return an {@link Optional} with information about the run's videos
     */
    public Optional<RunVideos> getVideos() {
        return Optional.ofNullable(videos);
    }

    /**
     *
     *
     * @return an {@link Optional} with the run comment
     */
    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    /**
     *
     *
     * @return
     */
    public RunStatus getStatus() {
        return status;
    }

    /**
     *
     *
     * @return
     */
    public List<RunPlayer> getPlayers() {
        return players;
    }

    /**
     * Returns the {@link LocalDate} that this run was actually ran.
     *
     * @return
     */
    public Optional<LocalDate> getDateRan() {
        return Optional.ofNullable(date);
    }

    /**
     * Returns the {@link Instant} that this run was submitted to SRC.
     *
     * @return
     */
    public Optional<Instant> getSubmitTime() {
        return Optional.ofNullable(submitted);
    }

    /**
     *
     *
     * @return a {@link RunTimes} object that has timing info
     */
    public RunTimes getRunTimes() {
        return times;
    }

    /**
     *
     *
     * @return a {@link RunSystem} object that has system info
     */
    public RunSystem getSystem() {
        return system;
    }

    /**
     *
     *
     * @return a {@link Link} wrapped in an {@link Optional} that contains info about splits
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