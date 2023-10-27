package treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

/**
 * Simple class to store name color info.
 */
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

    /**
     *
     * @return
     */
    public String getLight() {
        return light;
    }

    /**
     *
     * @return
     */
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
