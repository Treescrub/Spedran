package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

class CategoryPlayers {
    private boolean isExact;
    private int playerCount;

    CategoryPlayers(JSONObject data) {
        isExact = data.getString("type").equals("exactly");
        playerCount = data.getInt("value");
    }
}

public class Category extends Resource {
    private String name;
    private URL weblink;
    private Boolean isPerLevel;
    private String rules;
    private CategoryPlayers players;
    private Boolean miscellaneous;

    public Category(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Category(JSONObject data) {
        name = data.getString("name");
        try {
            weblink = new URL(data.getString("weblink"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        isPerLevel = data.getString("type").equals("per-level");
        rules = data.getString("rules");
        players = new CategoryPlayers(data.getJSONObject("players"));
        miscellaneous = data.getBoolean("miscellaneous");
    }

    public String getName() {
        return name;
    }

    public URL getWeblink() {
        return weblink;
    }

    public Boolean isPerLevel() {
        return isPerLevel;
    }

    public String getRules() {
        return rules;
    }

    public CategoryPlayers getPlayers() {
        return players;
    }

    public Boolean getMiscellaneous() {
        return miscellaneous;
    }
}
