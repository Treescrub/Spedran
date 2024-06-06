package com.github.treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 *
 */
public class UserLocation {
    private LocationInfo country;
    private LocationInfo region;

    public UserLocation(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        country = new LocationInfo(data.getJSONObject("country"));
        region = data.isNull("region") ? null : new LocationInfo(data.getJSONObject("region"));
    }

    /**
     *
     * @return
     */
    public LocationInfo getCountry() {
        return country;
    }

    /**
     *
     * @return
     */
    public Optional<LocationInfo> getRegion() {
        return Optional.ofNullable(region);
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "country=" + country +
                ", region=" + region +
                '}';
    }
}
