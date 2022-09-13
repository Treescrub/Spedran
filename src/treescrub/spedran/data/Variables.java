package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

class VariableValue {
    private String label;
    private String rules;
    private Map<String, Boolean> flags;

    public VariableValue(JSONObject data) {
        label = data.getString("label");
        rules = data.optString("rules", null);
        flags = new HashMap<>();
        for(String key : data.getJSONObject("flags").keySet()) {
            flags.put(key, data.getJSONObject("flags").getBoolean(key));
        }
    }
}

public class Variables {
    private String id;
    private String name;
    private String category;
    private String scope;
    private boolean mandatory;
    private boolean userDefined;
    private boolean obsoletes;
    private Map<String, VariableValue> values;
    private String defaultValue;
    private boolean isSubcategory;

    public Variables(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Variables(JSONObject data) {
        id = data.getString("id");
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

    public String getId() {
        return id;
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
