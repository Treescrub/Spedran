package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Optional;

public class Level extends IdentifiableNamedResource {
    private String weblink;
    private String rules;

    public Level(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Level(JSONObject data) {
        super(data);
    }

    public Level(String data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        weblink = data.getString("weblink");
        rules = data.optString("rules", null);
    }

    public String getWeblink() {
        return weblink;
    }

    public Optional<String> getRules() {
        return Optional.ofNullable(rules);
    }

    @Override
    public String toString() {
        return "Level[" + id + "]{" +
                "name='" + name + '\'' +
                "}";
    }
}
