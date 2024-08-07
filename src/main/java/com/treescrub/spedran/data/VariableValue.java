package com.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A value for a {@link Variable}.
 * <br>
 * Contains info about the value label. Also has rules text and flags if the variable is a subcategory.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class VariableValue {
    private final String label;
    private final String rules;
    private final Map<String, Boolean> flags;

    VariableValue(JSONObject data) {
        label = data.getString("label");
        rules = data.optString("rules", null);
        Map<String, Boolean> tempFlags = new HashMap<>();
        if(data.has("flags")) {
            JSONObject flagsObject = data.getJSONObject("flags");
            for(String key : flagsObject.keySet()) {
                if(flagsObject.isNull(key)) {
                    tempFlags.put(key, null);
                } else {
                    tempFlags.put(key, flagsObject.getBoolean(key));
                }
            }
        }
        flags = Collections.unmodifiableMap(tempFlags);
    }

    /**
     * Gets the label for this value.
     *
     * @return the label text
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets the rules text if the variable is marked as a subcategory.
     *
     * @return an {@link Optional} with the rules text, empty if variable is not a subcategory
     */
    public Optional<String> getRules() {
        return Optional.ofNullable(rules);
    }

    /**
     * Gets a {@link Map} of flags.
     * <br>
     * Currently, the only flag is {@code miscellaneous}.
     *
     * @return an unmodifiable {@code Map} of flags, empty if variable is not a subcategory
     */
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
