package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all {@link Category}s of a given {@link Game}.
 */
public class GameCategoriesRequest extends ResourceCollectionRequest<Category> {
    @SuppressWarnings("unused")
    public GameCategoriesRequest(String id) {
        super(HttpMethod.GET, "games/{id}/categories", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public GameCategoriesRequest(Game game) {
        this(game.getId());
    }

    /**
     * Sets whether miscellaneous categories should be returned.
     * <p>
     * Defaults to {@code true}.
     * @param includeMiscellaneous whether to include miscellaneous categories in the results
     * @return this object
     */
    @SuppressWarnings("unused")
    public GameCategoriesRequest miscellaneous(boolean includeMiscellaneous) {
        setParameter("miscellaneous", includeMiscellaneous);
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
