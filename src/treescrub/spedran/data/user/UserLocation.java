package treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

import java.util.Optional;

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

    public LocationInfo getCountry() {
        return country;
    }

    public Optional<LocationInfo> getRegion() {
        return Optional.ofNullable(region);
    }
}
