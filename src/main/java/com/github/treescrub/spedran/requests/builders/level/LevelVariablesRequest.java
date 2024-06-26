package com.github.treescrub.spedran.requests.builders.level;

import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.Variable;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

public class LevelVariablesRequest extends ResourceCollectionRequest<Variable> {
    public LevelVariablesRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/variables", Map.of("id", id));
    }

    public LevelVariablesRequest(Level level) {
        this(level.getId());
    }

    public LevelVariablesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public LevelVariablesRequest sortByMandatory() {
        setSortParameter("mandatory");
        return this;
    }

    public LevelVariablesRequest sortByUserDefined() {
        setSortParameter("user-defined");
        return this;
    }

    public LevelVariablesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    public LevelVariablesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
