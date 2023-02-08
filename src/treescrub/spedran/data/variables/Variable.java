package treescrub.spedran.data.variables;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.IdentifiableNamedResource;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public Optional<String> getCategory() {
        return Optional.ofNullable(category);
    }

    public VariableScope getScope() {
        return scope;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public boolean isUserDefined() {
        return userDefined;
    }

    public boolean isObsoleting() {
        return obsoletes;
    }

    public Map<String, VariableValue> getValues() {
        return values;
    }

    public Optional<String> getDefaultValue() {
        return Optional.ofNullable(defaultValue);
    }

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
