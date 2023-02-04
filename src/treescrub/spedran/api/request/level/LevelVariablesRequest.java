package treescrub.spedran.api.request.level;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.variables.Variable;

import java.util.Map;
import java.util.function.Function;

public class LevelVariablesRequest extends ResourceCollectionRequest<Variable> {
    public LevelVariablesRequest(String id) {
        super(HttpMethod.GET, "levels/{id}/variables", Map.of("id", id));
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
    protected Function<JSONObject, Variable> getConstructor() {
        return Variable::new;
    }
}
