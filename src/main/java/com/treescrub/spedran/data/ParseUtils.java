package com.treescrub.spedran.data;

import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

class ParseUtils {
    static <T extends IdentifiableResource> List<EmbeddableResource<T>> getEmbeddableResourceList(Object data, Function<JSONObject, T> constructorFunc) {
        List<EmbeddableResource<T>> list = new ArrayList<>();
        if(data instanceof JSONArray) {
            JSONArray array = (JSONArray) data;
            for(int i = 0; i < array.length(); i++) {
                list.add(new EmbeddableResource<>(array.getString(i)));
            }
        } else {
            JSONArray array = ((JSONObject) data).getJSONArray("data");
            for(int i = 0; i < array.length(); i++) {
                list.add(new EmbeddableResource<>(constructorFunc.apply(array.getJSONObject(i))));
            }
        }

        return Collections.unmodifiableList(list);
    }

    static <T extends IdentifiableResource> EmbeddableResource<T> getEmbeddableResource(JSONObject data, String key, Function<JSONObject, T> constructorFunc) {
        if(data.isNull(key) || (data.get(key) instanceof JSONObject && data.getJSONObject(key).get("data") instanceof JSONArray)) {
            return null;
        }

        if(data.get(key) instanceof String) {
            return new EmbeddableResource<>(data.getString(key));
        } else {
            data = data.getJSONObject(key).getJSONObject("data");
            return new EmbeddableResource<>(constructorFunc.apply(data));
        }
    }

    static <T> List<T> getEmbeddedResourceList(JSONObject data, String key, Function<JSONObject, T> constructorFunc) {
        if(!data.has(key)) {
            return null;
        }

        List<T> list = new ArrayList<>();
        data = data.getJSONObject(key);
        JSONArray array = data.getJSONArray("data");
        for(int i = 0; i < array.length(); i++) {
            list.add(constructorFunc.apply(array.getJSONObject(i)));
        }

        return Collections.unmodifiableList(list);
    }

    static <T> T getEmbeddedResource(JSONObject data, String key, Function<JSONObject, T> constructorFunc) {
        if(!data.has(key) || (data.get(key) instanceof JSONObject && data.getJSONObject(key).get("data") instanceof JSONArray)) {
            return null;
        }

        return constructorFunc.apply(data.getJSONObject(key).getJSONObject("data"));
    }
}
