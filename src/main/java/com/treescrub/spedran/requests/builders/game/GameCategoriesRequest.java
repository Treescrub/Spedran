package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.requests.SortDirection;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all {@link Category}s of a given {@link Game}.
 */
public class GameCategoriesRequest extends ResourceCollectionRequest<Category> {
    @SuppressWarnings("unused")
    protected GameCategoriesRequest(String id) {
        super(HttpMethod.GET, "games/{id}/categories", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code GameCategoriesRequest} builder.
     *
     * @param game the game to get the categories for
     * @return a {@code GameCategoriesRequest} builder
     */
    public static GameCategoriesRequest create(Game game) {
        checkResource(game, "game");

        return new GameCategoriesRequest(game.getId());
    }

    /**
     * Creates and returns a new {@code GameCategoriesRequest} builder.
     *
     * @param id the game to get the categories for
     * @return a {@code GameCategoriesRequest} builder
     */
    public static GameCategoriesRequest create(String id) {
        checkId(id);

        return new GameCategoriesRequest(id);
    }

    /**
     * Sets whether miscellaneous categories should be returned.
     * <p>
     * Defaults to {@code true}.
     *
     * @param includeMiscellaneous whether to include miscellaneous categories in the results
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameCategoriesRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    /**
     * Embed the game for each category.
     *
     * @return this object
     * @see Category#getGame()
     */
    public GameCategoriesRequest embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embeds the game for each category and any provided embeds for the game.
     *
     * @param builder the embed builder for the game
     * @return this object
     * @see Category#getGame()
     */
    public GameCategoriesRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    /**
     * Embed the variables for each category.
     *
     * @return this object
     * @see Category#getVariables()
     */
    public GameCategoriesRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    /**
     * Sorts the returned categories alphanumerically by name.
     *
     * @return this object
     * @see Category#getName()
     */
    @SuppressWarnings("unused")
    public GameCategoriesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the returned categories by the miscellaneous flag.
     *
     * @return this object
     * @see Category#isMiscellaneous()
     */
    @SuppressWarnings("unused")
    public GameCategoriesRequest sortByMiscellaneous() {
        setSortParameter("miscellaneous");
        return this;
    }

    /**
     * Sorts the returned categories by the moderator defined position.
     *
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameCategoriesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    /**
     * Sets the direction to sort the returned categories.
     *
     * @param direction the direction to sort, either ascending or descending
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameCategoriesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Category> getDataClass() {
        return Category.class;
    }
}
