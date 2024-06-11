package com.github.treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

/**
 * Represents a color preset.
 * <br>
 * Has light and dark hex color codes for light and dark backgrounds.
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
     * Gets the hex color code for use on light backgrounds.
     *
     * @return a hex color code starting with {@code #}
     */
    public String getLight() {
        return light;
    }

    /**
     * Gets the hex color code for use on dark backgrounds.
     *
     * @return a hex color code starting with {@code #}
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
