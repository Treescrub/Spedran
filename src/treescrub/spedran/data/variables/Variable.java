package treescrub.spedran.data.variables;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Variable {
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

    public Variable(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Variable(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return id.equals(variable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
