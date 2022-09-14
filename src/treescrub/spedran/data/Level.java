package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Optional;

public class Level extends Resource {
    private String id;
    private String name;
    private String weblink;
    private String rules;

    public Level(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Level(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
        weblink = data.getString("weblink");
        rules = data.optString("rules", null);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWeblink() {
        return weblink;
    }

    public Optional<String> getRules() {
        return Optional.ofNullable(rules);
    }
}
