package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.level.LevelCategoriesRequest;
import treescrub.spedran.api.request.level.LevelRecordsRequest;
import treescrub.spedran.api.request.level.LevelVariablesRequest;

import java.util.Optional;

/**
 *
 */
public class Level extends IdentifiableNamedResource {
    private String weblink;
    private String rules;

    public Level(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Level(JSONObject data) {
        super(data);
    }

    public LevelCategoriesRequest getCategories() {
        return new LevelCategoriesRequest(this);
    }

    public LevelRecordsRequest getRecords() {
        return new LevelRecordsRequest(this);
    }

    public LevelVariablesRequest getVariables() {
        return new LevelVariablesRequest(this);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        weblink = data.getString("weblink");
        rules = data.optString("rules", null);
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
