package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.variables.Variable;

import java.util.Map;
import java.util.function.Function;

public class CategoryVariablesRequest extends ResourceCollectionRequest<Variable> {
    public CategoryVariablesRequest(String id) {
        super(HttpMethod.GET, "categories/{id}/variables", Map.of("id", id));
    }

    public CategoryVariablesRequest sortByName() {
        setSortParameter("name");
        return this;
    }

    public CategoryVariablesRequest sortByMandatory() {
        setSortParameter("mandatory");
        return this;
    }

    public CategoryVariablesRequest sortByUserDefined() {
        setSortParameter("user-defined");
        return this;
    }

    public CategoryVariablesRequest sortByPosition() {
        setSortParameter("pos");
        return this;
    }

    public CategoryVariablesRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Variable> getConstructor() {
        return Variable::new;
    }
}
