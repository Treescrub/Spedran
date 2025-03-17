package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Genre;
import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import com.treescrub.spedran.requests.builders.embed.GameEmbedBuilder;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get the possible {@link Category}s for a given {@link Level}.
 */
public class LevelCategoriesRequest extends ResourceCollectionRequest<Category> {
    @SuppressWarnings("unused")
    protected LevelCategoriesRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/categories", Map.of("id", id));
    }

    public static LevelCategoriesRequest create(Level level) {
        checkResource(level, "level");

        return new LevelCategoriesRequest(level.getId());
    }

    public static LevelCategoriesRequest create(String id) {
        checkId(id);

        return new LevelCategoriesRequest(id);
    }

    /**
     * Restricts whether miscellaneous categories should be in the results.
     *
     * @param includeMiscellaneous {@code true} to include miscellaneous categories, otherwise {@code false}
     * @return this {@code LevelCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
        return this;
    }

    /**
     * Embed the game for each category.
     *
     * @return this object
     *
     * @see Category#getGame()
     */
    public LevelCategoriesRequest embedGame() {
        addEmbed("game");
        return this;
    }

    /**
     * Embeds the game for each category and any provided embeds for the category.
     *
     * @param builder the embed builder for the category
     * @return this object
     *
     * @see Category#getGame()
     */
    public LevelCategoriesRequest embedGame(GameEmbedBuilder builder) {
        addEmbed(builder.getEmbedStrings(), "game");
        return this;
    }

    /**
     * Embed the applicable variables for each category.
     *
     * @return this object
     *
     * @see Category#getVariables()
     */
    public LevelCategoriesRequest embedVariables() {
        addEmbed("variables");
        return this;
    }

    /**
     * Sorts the results alphanumerically by the category name.
     *
     * @return this {@code LevelCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the results by the miscellaneous boolean flag.
     *
     * @return this {@code LevelCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest sortByMiscellaneous() {
        setSortParameter("miscellaneous");
        return this;
    }

    /**
     * Sorts the results by the moderator defined category position.
     *
     * @return this {@code LevelCategoriesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code UsersRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelCategoriesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Category> getDataClass() {
        return Category.class;
    }
}
