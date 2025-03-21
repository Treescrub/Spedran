package com.treescrub.spedran.requests.builders;

import com.treescrub.spedran.SingleResourceRequest;
import com.treescrub.spedran.data.Variable;
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

    /**
     * Creates and returns a new {@code VariableRequest} builder.
     *
     * @param variable the variable to get
     * @return a {@code VariableRequest} builder
     */
    public static VariableRequest create(Variable variable) {
        checkResource(variable, "variable");

        return new VariableRequest(variable.getId());
    }

    /**
     * Creates and returns a new {@code VariableRequest} builder.
     *
     * @param id the variable to get
     * @return a {@code VariableRequest} builder
     */
    public static VariableRequest create(String id) {
        checkId(id);

        return new VariableRequest(id);
    }

    @Override
    protected Class<Variable> getDataClass() {
        return Variable.class;
    }
}
