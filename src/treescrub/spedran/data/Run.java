package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

class RunStatus {

}

class RunPlayer {

}

class RunTimes {

}

class RunSystem {

}

public class Run extends Resource {
    private URL weblink;
    private String game;
    private String level;
    private Category category;
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

    public Run(JSONObject data) {
        try {
            weblink = new URL(data.getString("weblink"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        game = data.getString("game");
        level = data.getString("level");
    }
}