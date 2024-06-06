package com.github.treescrub.spedran.api.request.game;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.api.request.ResourceCollectionRequest;
import com.github.treescrub.spedran.api.request.SortDirection;
import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.game.Game;

import java.util.Map;
import java.util.function.Function;

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
    protected Function<JSONObject, Level> getConstructor() {
        return Level::new;
    }
}
