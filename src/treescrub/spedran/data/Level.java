package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Optional;

public class Level extends IdentifiableResource {
    private String name;
    private String weblink;
    private String rules;

    public Level(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Level(JSONObject data) {
        super(data);
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        name = data.getString("name");
        weblink = data.getString("weblink");
        rules = data.optString("rules", null);
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
