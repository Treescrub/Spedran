package com.github.treescrub.spedran.requests.builders.game;

import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all levels of a given game.
 */
public class GameLevelsRequest extends ResourceCollectionRequest<Level> {
    public GameLevelsRequest(String id) {
        super(HttpMethod.GET, "games/{id}/levels", Map.of("id", id));
    }

    public GameLevelsRequest(Game game) {
        this(game.getId());
    }

    /**
     * Sorts the returned levels alphanumerically by name.
     *
     * @return this object
     * @see Level#getName()
     */
    public GameLevelsRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the returned levels by the moderator defined position.
     *
     * @return this object
     */
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
    public GameLevelsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Level> getDataClass() {
        return Level.class;
    }
}
