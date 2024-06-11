package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.api.request.level.LevelCategoriesRequest;
import com.github.treescrub.spedran.api.request.level.LevelRecordsRequest;
import com.github.treescrub.spedran.api.request.level.LevelVariablesRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * A specific level in a {@link com.github.treescrub.spedran.data.game.Game}.
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

    /**
     * Gets a new {@link LevelCategoriesRequest} builder object to request categories for this level.
     *
     * @return a {@code LevelCategoriesRequest} builder
     */
    public LevelCategoriesRequest getCategories() {
        return new LevelCategoriesRequest(this);
    }

    /**
     * Gets a new {@link LevelRecordsRequest} builder object to request records for this level.
     *
     * @return a {@code LevelRecordsRequest} builder
     */
    public LevelRecordsRequest getRecords() {
        return new LevelRecordsRequest(this);
    }

    /**
     * Gets a new {@link LevelVariablesRequest} builder object to request variables for this level.
     *
     * @return a {@code LevelVariablesRequest} builder
     */
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
     * Gets the link to this level on SRC.
     *
     * @return a link to the level on SRC
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     * Gets the rules text for this level.
     *
     * @return an {@link Optional} with the rules text if it is set, empty if no level specific rules were set
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
