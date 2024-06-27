package com.github.treescrub.spedran.requests.builders;

import com.github.treescrub.spedran.data.Variable;
import com.github.treescrub.spedran.requests.SingleResourceRequest;
import kong.unirest.HttpMethod;

import java.util.Map;

public class VariableRequest extends SingleResourceRequest<Variable> {
    public VariableRequest(String id) {
        super(HttpMethod.GET, "variables/{id}", Map.of("id", id));
    }

    public VariableRequest(Variable variable) {
        this(variable.getId());
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
