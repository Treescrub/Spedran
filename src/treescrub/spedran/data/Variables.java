package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

class VariablesScope {

}

class VariablesValues {

}

public class Variables {
    private String id;
    private String name;
    private String category;
    private String type;
    private boolean mandatory;
    private boolean userDefined;
    private boolean obsoletes;
    private VariablesValues values;
    private boolean isSubcategory;

    public Variables(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Variables(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
        category = data.optString("category", null);
        type = data.getJSONObject("scope").getString("type");
        mandatory = data.getBoolean("mandatory");
        userDefined = data.getBoolean("user-defined");
        obsoletes = data.getBoolean("obsoletes");

        isSubcategory = data.getBoolean("is-subcategory");
    }
}
