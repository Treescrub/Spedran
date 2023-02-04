package treescrub.spedran.api.request.game;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.variables.Variable;

import java.util.Map;
import java.util.function.Function;

public class GameVariablesRequest extends ResourceCollectionRequest<Variable> {
    public GameVariablesRequest(String id) {
        super(HttpMethod.GET, "games/{id}/variables", Map.of("id", id));
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
    protected Function<JSONObject, Variable> getConstructor() {
        return Variable::new;
    }
}
