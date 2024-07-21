package com.treescrub.spedran.data;

import kong.unirest.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ParseUtils {
    /**
     * Gets an unmodifiable list of strings.
     *
     * @param array the {@link JSONArray} to read from
     * @return an unmodifiable {@code List} of strings
     */
    static List<String> getStringList(JSONArray array) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < array.length(); i++) {
            list.add(array.getString(i));
        }

        list = Collections.unmodifiableList(list);

        return list;
    }
}
