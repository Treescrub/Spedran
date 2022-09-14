package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

public class Category extends Resource {
    private String name;
    private String weblink;
    private Boolean isPerLevel;
    private String rules;
    private CategoryPlayers players;
    private Boolean miscellaneous;

    public Category(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Category(JSONObject data) {
        name = data.getString("name");
        weblink = data.getString("weblink");
        isPerLevel = data.getString("type").equals("per-level");
        rules = data.getString("rules");
        players = new CategoryPlayers(data.getJSONObject("players"));
        miscellaneous = data.getBoolean("miscellaneous");
    }

    public String getName() {
        return name;
    }

    public String getWeblink() {
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
