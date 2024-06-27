package com.github.treescrub.spedran.requests.builders.game;

import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.data.Variable;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all the {@link Variable}s of a {@link Game}.
 */
public class GameVariablesRequest extends ResourceCollectionRequest<Variable> {
    public GameVariablesRequest(String id) {
        super(HttpMethod.GET, "games/{id}/variables", Map.of("id", id));
    }

    public GameVariablesRequest(Game game) {
        this(game.getId());
    }

    /**
     * Sorts the variables alphanumerically by the variable name.
     *
     * @return this {@code GameVariablesRequest} builder
     */
    public GameVariablesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the variables by the {@link Variable#isMandatory()} boolean flag.
     *
     * @return this {@code GameVariablesRequest} builder
     */
    public GameVariablesRequest sortByMandatory() {
        setSortParameter("mandatory");
        return this;
    }

    /**
     * Sorts the variables by the {@link Variable#isUserDefined()} boolean flag.
     *
     * @return this {@code GameVariablesRequest} builder
     */
    public GameVariablesRequest sortByUserDefined() {
        setSortParameter("user-defined");
        return this;
    }

    /**
     * Sorts the variables by the moderator defined position.
     *
     * @return this {@code GameVariablesRequest} builder
     */
    public GameVariablesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code GamesRequest} builder
     */
    public GameVariablesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
