package com.github.treescrub.spedran.requests.builders.category;

import com.github.treescrub.spedran.data.Category;
import com.github.treescrub.spedran.data.Variable;
import com.github.treescrub.spedran.requests.ResourceCollectionRequest;
import com.github.treescrub.spedran.requests.SortDirection;
import kong.unirest.HttpMethod;

import java.util.Map;

public class CategoryVariablesRequest extends ResourceCollectionRequest<Variable> {
    public CategoryVariablesRequest(String id) {
        super(HttpMethod.GET, "categories/{id}/variables", Map.of("id", id));
    }

    public CategoryVariablesRequest(Category category) {
        this(category.getId());
    }

    /**
     * Sorts the returned variables alphanumerically by name.
     *
     * @return this object
     * @see Variable#getName()
     */
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
    public CategoryVariablesRequest sortByUserDefined() {
        setSortParameter("user-defined");
        return this;
    }

    /**
     * Sorts the returned variables by the moderator defined position.
     *
     * @return this object
     */
    public CategoryVariablesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    /**
     * Sets the direction to sort the returned variables.
     *
     * @param direction the direction to sort, either ascending or descending
     * @return this object
     */
    public CategoryVariablesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
