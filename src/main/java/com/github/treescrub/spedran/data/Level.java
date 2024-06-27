package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import com.github.treescrub.spedran.requests.builders.LevelCategoriesRequest;
import com.github.treescrub.spedran.requests.builders.LevelRecordsRequest;
import com.github.treescrub.spedran.requests.builders.LevelVariablesRequest;
import com.github.treescrub.spedran.requests.builders.run.RunsRequest;
import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * A specific level in a {@link Game}.
 */
public class Level extends IdentifiableNamedResource {
    private final String weblink;
    private final String rules;

    Level(JSONObject data) {
        super(data);

        weblink = data.getString("weblink");
        rules = data.optString("rules", null);
    }

    /**
     * Gets a new {@link RunsRequest} builder object to request all runs on this level.
     *
     * @return a {@code RunsRequest} builder
     */
    public RunsRequest getRuns() {
        return Spedran.getRuns().level(this);
    }

    /**
     * Gets a new {@link LevelCategoriesRequest} builder object to request categories for this level.
     *
     * @return a {@code LevelCategoriesRequest} builder
     */
    public LevelCategoriesRequest getCategories() {
        return Spedran.getLevelCategories(id);
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
