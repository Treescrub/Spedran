package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.requests.SortDirection;
import com.treescrub.spedran.requests.builders.embed.CategoryEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all {@link Level}s of a given {@link Game}.
 */
public class GameLevelsRequest extends ResourceCollectionRequest<Level> {
    @SuppressWarnings("unused")
    protected GameLevelsRequest(String id) {
        super(HttpMethod.GET, "games/{id}/levels", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code GameLevelsRequest} builder.
     *
     * @param game the game to get the levels for
     * @return a {@code GameLevelsRequest} builder
     */
    public static GameLevelsRequest create(Game game) {
        checkResource(game, "game");

        return new GameLevelsRequest(game.getId());
    }

    /**
     * Creates and returns a new {@code GameLevelsRequest} builder.
     *
     * @param id the game to get the levels for
     * @return a {@code GameLevelsRequest} builder
     */
    public static GameLevelsRequest create(String id) {
        checkId(id);

        return new GameLevelsRequest(id);
    }

    /**
     * Embed the categories for each level.
     *
     * @return this object
     * @see Level#getCategories()
     */
    public GameLevelsRequest embedCategories() {
        addEmbed("categories");
        return this;
    }

    /**
     * Embeds the categories for each level and any provided embeds for the category.
     *
     * @param builder the embed builder for the category
     * @return this object
     * @see Level#getCategories()
     */
    public GameLevelsRequest embedCategories(CategoryEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "categories");
        return this;
    }

    /**
     * Embed the applicable variables for each level.
     *
     * @return this object
     * @see Level#getVariables()
     */
    public GameLevelsRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    /**
     * Sorts the returned levels alphanumerically by name.
     *
     * @return this object
     * @see Level#getName()
     */
    @SuppressWarnings("unused")
    public GameLevelsRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the returned levels by the moderator defined position.
     *
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameLevelsRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    /**
     * Sets the direction to sort the returned levels.
     *
     * @param direction the direction to sort, either ascending or descending
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameLevelsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Level> getDataClass() {
        return Level.class;
    }
}
