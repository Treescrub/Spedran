package treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

public class UserLocation {
    private LocationInfo country;
    private LocationInfo region;

    public UserLocation(JSONObject data) {
        country = new LocationInfo(data.getJSONObject("country"));
        region = data.isNull("region") ? null : new LocationInfo(data.getJSONObject("region"));
    }

    public LocationInfo getCountry() {
        return country;
    }

    public LocationInfo getRegion() {
        return region;
    }
}
