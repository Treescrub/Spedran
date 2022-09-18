package treescrub.spedran.data.run;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Link;
import treescrub.spedran.data.Resource;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Run extends Resource {
    private String id;
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
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Run(JSONObject data) {
        id = data.getString("id");
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

    public String getId() {
        return id;
    }

    public String getWeblink() {
        return weblink;
    }

    public String getGame() {
        return game;
    }

    public Optional<String> getLevel() {
        return Optional.ofNullable(level);
    }

    public String getCategory() {
        return category;
    }

    public Optional<RunVideos> getVideos() {
        return Optional.ofNullable(videos);
    }

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public RunStatus getStatus() {
        return status;
    }

    public List<RunPlayer> getPlayers() {
        return players;
    }

    public Optional<LocalDate> getDateRan() {
        return Optional.ofNullable(date);
    }

    public Optional<Instant> getSubmitTime() {
        return Optional.ofNullable(submitted);
    }

    public RunTimes getRunTimes() {
        return times;
    }

    public RunSystem getSystem() {
        return system;
    }

    public Link getSplits() {
        return splits;
    }

    public Map<String, String> getVariableValues() {
        return values;
    }
}