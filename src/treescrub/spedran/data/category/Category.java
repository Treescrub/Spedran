package treescrub.spedran.data.category;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.IdentifiableNamedResource;

public class Category extends IdentifiableNamedResource {
    private String weblink;
    private boolean isPerLevel;
    private String rules;
    private CategoryPlayers players;
    private boolean miscellaneous;

    public Category(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Category(JSONObject data) {
        super(data);
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        weblink = data.getString("weblink");
        isPerLevel = data.getString("type").equals("per-level");
        rules = data.getString("rules");
        players = new CategoryPlayers(data.getJSONObject("players"));
        miscellaneous = data.getBoolean("miscellaneous");
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

    public boolean isMiscellaneous() {
        return miscellaneous;
    }

    @Override
    public String toString() {
        return "Category[" + id + "]{" +
                "name='" + name + '\'' +
                ", isPerLevel=" + isPerLevel +
                ", miscellaneous=" + miscellaneous +
                "}";
    }
}
