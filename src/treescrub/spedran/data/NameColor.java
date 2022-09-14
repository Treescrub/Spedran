package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

public class NameColor {
    private String light;
    private String dark;

    public NameColor(JSONObject data) {
        light = data.getString("light");
        dark = data.getString("dark");
    }

    public String getLight() {
        return light;
    }

    public String getDark() {
        return dark;
    }
}
