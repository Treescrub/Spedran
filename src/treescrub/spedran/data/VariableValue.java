package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VariableValue {
    private String label;
    private String rules;
    private Map<String, Boolean> flags;

    public VariableValue(JSONObject data) {
        label = data.getString("label");
        rules = data.optString("rules", null);
        flags = new HashMap<>();
        for (String key : data.getJSONObject("flags").keySet()) {
            flags.put(key, data.getJSONObject("flags").getBoolean(key));
        }
    }
}
