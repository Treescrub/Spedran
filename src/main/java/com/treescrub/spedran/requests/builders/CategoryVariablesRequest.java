package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Category;
import com.treescrub.spedran.data.Variable;
import com.treescrub.spedran.requests.ResourceCollectionRequest;
import com.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get all {@link Variable}s for a given {@link Category}.
 */
public class CategoryVariablesRequest extends ResourceCollectionRequest<Variable> {
    @SuppressWarnings("unused")
    public CategoryVariablesRequest(String id) {
        super(HttpMethod.GET, "categories/{id}/variables", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public CategoryVariablesRequest(Category category) {
        this(category.getId());
    }

    /**
     * Sorts the returned variables alphanumerically by name.
     *
     * @return this object
     * @see Variable#getName()
     */
    @SuppressWarnings("unused")
    public CategoryVariablesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    /**
     * Sorts the returned variables by mandatory flag.
     *
     * @return this object
     * @see Variable#isMandatory()
     */
    @SuppressWarnings("unused")
    public CategoryVariablesRequest sortByMandatory() {
        setSortParameter("mandatory");
        return this;
    }

    /**
     * Sorts the returned variables by user defined flag.
     *
     * @return this object
     * @see Variable#isUserDefined()
     */
    @SuppressWarnings("unused")
    public CategoryVariablesRequest sortByUserDefined() {
        setSortParameter("user-defined");
        return this;
    }

    /**
     * Sorts the returned variables by the moderator defined position.
     *
     * @return this object
     */
    @SuppressWarnings("unused")
    public CategoryVariablesRequest sortByPosition() {
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
    public CategoryVariablesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
