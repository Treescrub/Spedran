package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.data.Variable;
import com.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

/**
 * A request builder to get a single {@link Variable}.
 */
public class VariableRequest extends SingleResourceRequest<Variable> {
    @SuppressWarnings("unused")
    public VariableRequest(String id) {
        super(HttpMethod.GET, "variables/{id}", Map.of("id", id));
    }

    @SuppressWarnings("unused")
    public VariableRequest(Variable variable) {
        this(variable.getId());
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
