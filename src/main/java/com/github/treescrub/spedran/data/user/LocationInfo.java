package com.github.treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.data.Names;

import java.util.Objects;

/**
 * Contains a location code and {@link Names} for a location in the world.
 */
public class LocationInfo {
    private String code;
    private Names names;

    public LocationInfo(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        code = data.getString("code");
        names = new Names(data.getJSONObject("names"));
    }

    /**
     * Gets the code for this location.
     *
     * @return a {@code String} with the location code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the {@link Names} for this location.
     *
     * @return a {@code Names}
     */
    public Names getNames() {
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationInfo that = (LocationInfo) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "code='" + code + '\'' +
                ", names=" + names +
                '}';
    }
}
