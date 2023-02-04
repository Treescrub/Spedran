package treescrub.spedran.api.request.variable;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.SingleResourceRequest;
import treescrub.spedran.data.variables.Variable;

import java.util.Map;

public class VariableRequest extends SingleResourceRequest<Variable> {
    public VariableRequest(String id) {
        super(HttpMethod.GET, "variables/{id}", Map.of("id", id));
    }

    public VariableRequest(Variable variable) {
        this(variable.getId());
    }

    @Override
    protected Variable parse(JSONObject data) {
        return new Variable(data);
    }
}
