package com.treescrub.spedran.requests.builders.game;

import com.treescrub.spedran.data.Game;
import com.treescrub.spedran.data.Variable;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all the {@link Variable}s of a {@link Game}.
 */
public class GameVariablesRequest extends ResourceCollectionRequest<Variable> {
    @SuppressWarnings("unused")
    protected GameVariablesRequest(String id) {
        super(HttpMethod.GET, "games/{id}/variables", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code GameVariablesRequest} builder.
     *
     * @param game the game to get the variables for
     * @return a {@code GameVariablesRequest} builder
     */
    public static GameVariablesRequest create(Game game) {
        checkResource(game, "game");

        return new GameVariablesRequest(game.getId());
    }

    /**
     * Creates and returns a new {@code GameVariablesRequest} builder.
     *
     * @param id the game to get the variables for
     * @return a {@code GameVariablesRequest} builder
     */
    public static GameVariablesRequest create(String id) {
        checkId(id);

        return new GameVariablesRequest(id);
    }

    /**
     * Sorts the variables alphanumerically by the variable name.
     *
     * @return this {@code GameVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public GameVariablesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the variables by the {@link Variable#isMandatory()} boolean flag.
     *
     * @return this {@code GameVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public GameVariablesRequest sortByMandatory() {
        setSortParameter("mandatory");
        return this;
    }

    /**
     * Sorts the variables by the {@link Variable#isUserDefined()} boolean flag.
     *
     * @return this {@code GameVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public GameVariablesRequest sortByUserDefined() {
        setSortParameter("user-defined");
        return this;
    }

    /**
     * Sorts the variables by the moderator defined position.
     *
     * @return this {@code GameVariablesRequest} builder
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    public GameVariablesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
