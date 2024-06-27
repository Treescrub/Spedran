package com.github.treescrub.spedran.requests.builders.game;

import com.github.treescrub.spedran.data.Game;
import com.github.treescrub.spedran.data.Variable;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

public class GameVariablesRequest extends ResourceCollectionRequest<Variable> {
    public GameVariablesRequest(String id) {
        super(HttpMethod.GET, "games/{id}/variables", Map.of("id", id));
    }

    public GameVariablesRequest(Game game) {
        this(game.getId());
    }

    public GameVariablesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public GameVariablesRequest sortByMandatory() {
        setSortParameter("mandatory");
        return this;
    }

    public GameVariablesRequest sortByUserDefined() {
        setSortParameter("user-defined");
        return this;
    }

    public GameVariablesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    public GameVariablesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
