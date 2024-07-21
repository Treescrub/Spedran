package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.requests.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all {@link Level}s of a given {@link Game}.
 */
public class GameLevelsRequest extends ResourceCollectionRequest<Level> {
    @SuppressWarnings("unused")
    public GameLevelsRequest(String id) {
        super(HttpMethod.GET, "games/{id}/levels", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public GameLevelsRequest(Game game) {
        this(game.getId());
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
