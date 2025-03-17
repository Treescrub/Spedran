package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Region;
import com.treescrub.spedran.data.Variable;
import com.treescrub.spedran.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Variable}.
 */
public class VariableRequest extends SingleResourceRequest<Variable> {
    @SuppressWarnings("unused")
    protected VariableRequest(String id) {
        super(HttpMethod.GET, "variables/{id}", Map.of("id", id));
    }

    public static VariableRequest create(Variable variable) {
        checkResource(variable, "variable");

        return new VariableRequest(variable.getId());
    }

    public static VariableRequest create(String id) {
        checkId(id);

        return new VariableRequest(id);
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
