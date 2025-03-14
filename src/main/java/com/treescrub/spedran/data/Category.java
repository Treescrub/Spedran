package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.requests.builders.CategoryRecordsRequest;
import com.treescrub.spedran.requests.builders.CategoryVariablesRequest;
import com.treescrub.spedran.requests.builders.run.RunsRequest;
import kong.unirest.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A category of runs which has its own specific rules.
 * <br>
 * Common category names are {@code Any%}, {@code 100%}, and so on.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class Category extends IdentifiableNamedResource {
    private final String weblink;
    private final boolean isPerLevel;
    private final String rules;
    private final CategoryPlayers players;
    private final boolean miscellaneous;
    private final Game game;
    private final List<Variable> variables;

    Category(JSONObject data) {
        super(data);

        weblink = data.getString("weblink");
        isPerLevel = data.getString("type").equals("per-level");
        rules = data.getString("rules");
        players = new CategoryPlayers(data.getJSONObject("players"));
        miscellaneous = data.getBoolean("miscellaneous");
        game = data.has("game") ? new Game(data.getJSONObject("game").getJSONObject("data")) : null;
        if(data.has("variables")) {
            variables = new ArrayList<>();
            for(Object variableData : data.getJSONObject("variables").getJSONArray("data")) {
                variables.add(new Variable((JSONObject) variableData));
            }
        } else {
            variables = null;
        }
    }

    /**
     * Gets a new {@link RunsRequest} builder object to request all runs in this category.
     *
     * @return a {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest fetchRuns() {
        return Spedran.getRuns().category(this);
    }

    /**
     * Gets a new {@link CategoryRecordsRequest} builder object to request records for this category.
     *
     * @return a {@code CategoryRecordsRequest} builder
     */
    @SuppressWarnings("unused")
    public CategoryRecordsRequest fetchRecords() {
        return Spedran.getCategoryRecords(id);
    }

    /**
     * Gets a new {@link CategoryVariablesRequest} builder object to request variables for this category.
     *
     * @return a {@code CategoryVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public CategoryVariablesRequest fetchVariables() {
        return Spedran.getCategoryVariables(id);
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
    public boolean isPerLevel() {
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

    /**
     * Gets the game as an {@link Optional}.
     *
     * @return an {@link Optional} containing the game, empty if not embedded
     *
     * @see Game
     */
    public Optional<Game> getGame() {
        return Optional.ofNullable(game);
    }

    /**
     * Gets a {@code List} of variables applicable to this category as an {@link Optional}.
     *
     * @return an {@link Optional} containing the applicable variables, empty if not embedded
     *
     * @see Variable
     */
    public Optional<List<Variable>> getVariables() {
        return Optional.ofNullable(variables);
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
