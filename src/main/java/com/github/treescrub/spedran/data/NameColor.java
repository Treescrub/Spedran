package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.awt.*;

/**
 * Represents a color preset.
 * <br>
 * Has light and dark hex color codes for light and dark backgrounds.
 */
public class NameColor {
    private final Color light;
    private final Color dark;

    NameColor(JSONObject data) {
        light = Color.decode(data.getString("light"));
        dark = Color.decode(data.getString("dark"));
    }

    /**
     * Gets the {@link Color} for use on light backgrounds.
     *
     * @return a {@code Color} object with color info
     */
    public Color getLight() {
        return light;
    }

    /**
     * Gets the {@link Color} for use on dark backgrounds.
     *
     * @return a {@code Color} object with color info
     */
    public Color getDark() {
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
