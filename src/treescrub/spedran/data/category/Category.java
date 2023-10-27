package treescrub.spedran.data.category;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.category.CategoryRecordsRequest;
import treescrub.spedran.api.request.category.CategoryVariablesRequest;
import treescrub.spedran.data.IdentifiableNamedResource;

/**
 *
 */
public class Category extends IdentifiableNamedResource {
    private String weblink;
    private boolean isPerLevel;
    private String rules;
    private CategoryPlayers players;
    private boolean miscellaneous;

    public Category(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Category(JSONObject data) {
        super(data);
    }

    /**
     *
     * @return
     */
    public CategoryRecordsRequest getRecords() {
        return new CategoryRecordsRequest(this);
    }

    /**
     *
     * @return
     */
    public CategoryVariablesRequest getVariables() {
        return new CategoryVariablesRequest(this);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        weblink = data.getString("weblink");
        isPerLevel = data.getString("type").equals("per-level");
        rules = data.getString("rules");
        players = new CategoryPlayers(data.getJSONObject("players"));
        miscellaneous = data.getBoolean("miscellaneous");
    }

    /**
     *
     * @return
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     *
     * @return
     */
    public Boolean isPerLevel() {
        return isPerLevel;
    }

    /**
     *
     * @return
     */
    public String getRules() {
        return rules;
    }

    /**
     *
     * @return
     */
    public CategoryPlayers getPlayers() {
        return players;
    }

    /**
     *
     * @return
     */
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
