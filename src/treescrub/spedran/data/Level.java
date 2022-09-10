package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Level extends Resource {
    private String name;
    private URL weblink;
    private String rules;

    public Level(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Level(JSONObject data) {
        name = data.getString("name");
        try {
            weblink = new URL(data.getString("weblink"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        rules = data.optString("rules", null);
    }

    public String getName() {
        return name;
    }

    public URL getWeblink() {
        return weblink;
    }

    public Optional<String> getRules() {
        return Optional.ofNullable(rules);
    }
}
