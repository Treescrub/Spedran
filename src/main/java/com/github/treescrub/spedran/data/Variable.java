package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import kong.unirest.json.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A moderator defined variable for which a value can be set on a {@link Run}.
 */
public class Variable extends IdentifiableNamedResource {
    private final String category;
    private final VariableScope scope;
    private final boolean mandatory;
    private final boolean userDefined;
    private final boolean obsoletes;
    private final Map<String, VariableValue> values;
    private final String defaultValue;
    private final boolean isSubcategory;

    Variable(JSONObject data) {
        super(data);

        category = data.optString("category", null);
        scope = new VariableScope(data.getJSONObject("scope"));
        mandatory = data.getBoolean("mandatory");
        userDefined = data.getBoolean("user-defined");
        obsoletes = data.getBoolean("obsoletes");
        defaultValue = data.getJSONObject("values").optString("default", null);
        Map<String, VariableValue> tempValues = new HashMap<>();
        for(String valueId : data.getJSONObject("values").getJSONObject("values").keySet()) {
            tempValues.put(valueId, new VariableValue(data.getJSONObject("values").getJSONObject("values").getJSONObject(valueId)));
        }
        values = Collections.unmodifiableMap(tempValues);
        isSubcategory = data.getBoolean("is-subcategory");
    }


    /**
     * Gets the category ID that this variable applies to.
     *
     * @return an {@link Optional} with the category ID
     *
     * @see Spedran#getCategory(String)
     */
    public Optional<String> getCategory() {
        return Optional.ofNullable(category);
    }

    /**
     * Gets the {@link VariableScope} where this variable is usable.
     *
     * @return a {@code VariableScope} of this variable
     */
    public VariableScope getScope() {
        return scope;
    }

    /**
     * Gets whether the {@link User} submitting a run is required to set a value for this variable.
     *
     * @return {@code true} if this variable is required, {@code false} otherwise
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * Gets whether the {@link User} submitting a run can enter custom values for this variable.
     *
     * @return {@code true} if this variable can have custom values, {@code false} otherwise
     */
    public boolean isUserDefined() {
        return userDefined;
    }

    /**
     * Gets whether this variable having different values prevents runs from being obsoleted.
     *
     * @return {@code true} if runs will be obsolete even if they have different values for this variable, {@code false} otherwise
     */
    public boolean isObsoleting() {
        return obsoletes;
    }

    /**
     * Gets a {@link Map} to map variable value IDs to a {@link VariableValue}.
     *
     * @return a {@code Map} with keys being variable value IDs, and values being {@code VariableValue}
     */
    public Map<String, VariableValue> getValues() {
        return values;
    }

    /**
     * Gets the default value ID for this variable.
     *
     * @return the default value ID to use
     */
    public Optional<String> getDefaultValue() {
        return Optional.ofNullable(defaultValue);
    }

    /**
     * Gets whether this variable is handled as a subcategory.
     *
     * @return {@code true} if this variable is a subcategory, {@code false} otherwise
     */
    public boolean isSubcategory() {
        return isSubcategory;
    }

    @Override
    public String toString() {
        return "Variable[" + id + "]{" +
                "name='" + name + '\'' +
                ", mandatory=" + mandatory +
                ", isSubcategory=" + isSubcategory +
                ", category='" + category + '\'' +
                "}";
    }
}
