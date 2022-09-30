package treescrub.spedran.data.variables;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.IdentifiableResource;

import java.util.HashMap;
import java.util.Map;

public class Variable extends IdentifiableResource {
    private String name;
    private String category;
    private String scope;
    private boolean mandatory;
    private boolean userDefined;
    private boolean obsoletes;
    private Map<String, VariableValue> values;
    private String defaultValue;
    private boolean isSubcategory;

    public Variable(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Variable(JSONObject data) {
        super(data);
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        name = data.getString("name");
        category = data.optString("category", null);
        scope = data.getJSONObject("scope").getString("type");
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

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getScope() {
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

    public String getDefaultValue() {
        return defaultValue;
    }

    public boolean isSubcategory() {
        return isSubcategory;
    }
}
