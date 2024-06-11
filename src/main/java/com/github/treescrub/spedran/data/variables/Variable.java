package com.github.treescrub.spedran.data.variables;

import com.github.treescrub.spedran.data.IdentifiableNamedResource;
import com.github.treescrub.spedran.data.user.User;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A moderator defined variable for which a value can be set on a {@link com.github.treescrub.spedran.data.run.Run}.
 */
public class Variable extends IdentifiableNamedResource {
    private String category;
    private VariableScope scope;
    private boolean mandatory;
    private boolean userDefined;
    private boolean obsoletes;
    private Map<String, VariableValue> values;
    private String defaultValue;
    private boolean isSubcategory;

    public Variable(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Variable(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        category = data.optString("category", null);
        scope = new VariableScope(data.getJSONObject("scope"));
        mandatory = data.getBoolean("mandatory");
        userDefined = data.getBoolean("user-defined");
        obsoletes = data.getBoolean("obsoletes");
        defaultValue = data.getJSONObject("values").optString("default", null);
        values = new HashMap<>();
        for(String valueId : data.getJSONObject("values").getJSONObject("values").keySet()) {
            values.put(valueId, new VariableValue(data.getJSONObject("values").getJSONObject("values").getJSONObject(valueId)));
        }
        isSubcategory = data.getBoolean("is-subcategory");
    }

    /**
     * Gets the category ID that this variable applies to.
     *
     * @return an {@link Optional} with the category ID
     *
     * @see com.github.treescrub.spedran.api.Spedran#getCategory(String)
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
     * If the {@link User} submitting a run is required to set a value for this variable, returns {@code true}, otherwise {@code false}.
     *
     * @return whether the submitter of a run needs to set a value for this variable
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * If the {@link User} submitting a run can enter custom values, returns {@code true}, otherwise {@code false}.
     *
     * @return whether the submitter of a run can enter custom values
     */
    public boolean isUserDefined() {
        return userDefined;
    }

    /**
     * If this variable is used to display runs for the leaderboard, returns {@code true}, otherwise {@code false}.
     *
     * @return whether this variable can prevent a run from being considered obsolete
     */
    public boolean isObsoleting() {
        return obsoletes;
    }

    /**
     * A {@link Map} to map variable value IDs to a {@link VariableValue}.
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
     * If this variable should be handled as a subcategory, returns {@code true}, otherwise {@code false}.
     *
     * @return whether this variable is a subcategory
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
