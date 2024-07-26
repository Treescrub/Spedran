package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Level;
import com.treescrub.spedran.data.Variable;
import com.treescrub.spedran.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all the {@link Variable}s of a {@link Level}.
 */
public class LevelVariablesRequest extends ResourceCollectionRequest<Variable> {
    @SuppressWarnings("unused")
    public LevelVariablesRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/variables", Map.of("id", id));
    }

    public LevelVariablesRequest(Level level) {
        this(level.getId());
    }

    /**
     * Sorts the variables alphanumerically by the variable name.
     *
     * @return this {@code LevelVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelVariablesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the variables by the {@link Variable#isMandatory()} boolean flag.
     *
     * @return this {@code LevelVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelVariablesRequest sortByMandatory() {
        setSortParameter("mandatory");
        return this;
    }

    /**
     * Sorts the variables by the {@link Variable#isUserDefined()} boolean flag.
     *
     * @return this {@code LevelVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelVariablesRequest sortByUserDefined() {
        setSortParameter("user-defined");
        return this;
    }

    /**
     * Sorts the variables by the moderator defined position.
     *
     * @return this {@code LevelVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelVariablesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    /**
     * Sets the direction (ascending or descending) of the sorting.
     *
     * @param direction the sort direction
     * @return this {@code LevelVariablesRequest} builder
     */
    @SuppressWarnings("unused")
    public LevelVariablesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
