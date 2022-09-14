package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class RunPlayer {

}

class RunSystem {

}

public class Run extends Resource {
    private String id;
    private String weblink;
    private String game;
    private String level;
    private String category;
    private List<Link> videos;
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
        status = new RunStatus(data.getJSONObject("status"));
    }

    public RunStatus getStatus() {
        return status;
    }
}