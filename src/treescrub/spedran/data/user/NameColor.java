package treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

public class NameColor {
    private String light;
    private String dark;

    public NameColor(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        light = data.getString("light");
        dark = data.getString("dark");
    }

    public String getLight() {
        return light;
    }

    public String getDark() {
        return dark;
    }

    @Override
    public String toString() {
        return "NameColor{" +
                "light='" + light + '\'' +
                ", dark='" + dark + '\'' +
                '}';
    }
}
