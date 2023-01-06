package treescrub.spedran.data.variables;

import kong.unirest.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VariableValue {
    private String label;
    private String rules;
    private Map<String, Boolean> flags;

    public VariableValue(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        label = data.getString("label");
        rules = data.optString("rules", null);
        flags = new HashMap<>();
        if(data.has("flags")) {
            for (String key : data.getJSONObject("flags").keySet()) {
                flags.put(key, data.getJSONObject("flags").getBoolean(key));
            }
        }
    }

    public String getLabel() {
        return label;
    }

    public Optional<String> getRules() {
        return Optional.ofNullable(rules);
    }

    public Map<String, Boolean> getFlags() {
        return flags;
    }

    @Override
    public String toString() {
        return "VariableValue{" +
                "label='" + label + '\'' +
                '}';
    }
}
