package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

public class LocationInfo {
    private String code;
    private Names names;

    public LocationInfo(JSONObject data) {
        code = data.getString("code");
        names = new Names(data.getJSONObject("names"));
    }

    public String getCode() {
        return code;
    }

    public Names getNames() {
        return names;
    }
}
