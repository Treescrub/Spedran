package com.github.treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * A {@link User}s location in the world as set by the user.
 * <br>
 * Has country info and may have region info.
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
     * Gets the {@link LocationInfo} for the country.
     * The country code is ISO 3166-1 alpha-2.
     *
     * @return a {@code LocationInfo} with the country
     */
    public LocationInfo getCountry() {
        return country;
    }

    /**
     * Gets the {@link LocationInfo} for the region of the country
     * The region code is custom and specific to SRC.
     *
     * @return an {@link Optional} with the region location info
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
