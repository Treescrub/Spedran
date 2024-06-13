package com.github.treescrub.spedran.data.category;

import com.github.treescrub.spedran.api.request.category.CategoryRecordsRequest;
import com.github.treescrub.spedran.api.request.category.CategoryVariablesRequest;
import com.github.treescrub.spedran.data.IdentifiableNamedResource;
import kong.unirest.json.JSONObject;

/**
 * A category of runs which has its own specific rules.
 * <br>
 * Common category names are {@code Any%}, {@code 100%}, and so on.
 */
public class Category extends IdentifiableNamedResource {
    private final String weblink;
    private final boolean isPerLevel;
    private final String rules;
    private final CategoryPlayers players;
    private final boolean miscellaneous;

    public Category(JSONObject data) {
        super(data);

        weblink = data.getString("weblink");
        isPerLevel = data.getString("type").equals("per-level");
        rules = data.getString("rules");
        players = new CategoryPlayers(data.getJSONObject("players"));
        miscellaneous = data.getBoolean("miscellaneous");
    }

    /**
     * Gets a new {@link CategoryRecordsRequest} builder object to request records for this category.
     *
     * @return a {@code CategoryRecordsRequest} builder
     */
    public CategoryRecordsRequest getRecords() {
        return new CategoryRecordsRequest(this);
    }

    /**
     * Gets a new {@link CategoryVariablesRequest} builder object to request variables for this category.
     *
     * @return a {@code CategoryVariablesRequest} builder
     */
    public CategoryVariablesRequest getVariables() {
        return new CategoryVariablesRequest(this);
    }

    /**
     * Gets the link to this category on SRC.
     * <br><b>SRC API currently returns a link that does not work!</b>
     *
     * @return a link to the category on SRC
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     * If {@code true}, this category has specific levels, otherwise this category does not have levels.
     *
     * @return {@code true} if this category is per level, otherwise {@code false}
     */
    public Boolean isPerLevel() {
        return isPerLevel;
    }

    /**
     * Gets the moderator defined rules text for this category.
     *
     * @return rules text
     */
    public String getRules() {
        return rules;
    }

    /**
     * Gets the player count restriction for this category.
     *
     * @return a {@link CategoryPlayers}
     */
    public CategoryPlayers getPlayers() {
        return players;
    }

    /**
     * Is this category considered a miscellaneous category.
     *
     * @return is miscellaneous
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
