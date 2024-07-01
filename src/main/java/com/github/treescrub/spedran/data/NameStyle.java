package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Describes how the name for a {@link User} should be colored.
 * <br>
 * If the style is a gradient, {@link NameStyle#getStartColor()} and {@link NameStyle#getEndColor()} can be identical.
 */
public class NameStyle {
    /**
     * The styling type for a given name styling.
     */
    public enum Style {
        /**
         * The name color is one solid color.
         */
        SOLID,
        /**
         * The name color is a horizontal gradient, left to right.
         */
        GRADIENT,
    }

    private final Style style;
    private final NameColor color;
    private final NameColor startColor;
    private final NameColor endColor;

    NameStyle(JSONObject data) {
        style = Style.valueOf(data.getString("style").toUpperCase());
        if (style == Style.SOLID) {
            color = new NameColor(data.getJSONObject("color"));
            startColor = null;
            endColor = null;
        } else {
            color = null;
            startColor = new NameColor(data.getJSONObject("color-from"));
            endColor = new NameColor(data.getJSONObject("color-to"));
        }
    }

    /**
     * Gets the style of the name.
     * <p>
     * If {@link Style#SOLID}, the name color will be solid and {@link NameStyle#getColor()} will have the color preset.
     * <br>
     * If {@link Style#GRADIENT}, the name color will be a gradient left to right, from {@link NameStyle#getStartColor()} to {@link NameStyle#getEndColor()}.
     * <p>
     *
     * @return the color style for the user
     */
    public Style getStyle() {
        return style;
    }

    /**
     * Gets the color when {@link NameStyle#getStyle()} is {@link Style#SOLID}.
     *
     * @return an {@link Optional} with the {@link NameColor} if the style is solid, otherwise empty.
     */
    public Optional<NameColor> getColor() {
        return Optional.ofNullable(color);
    }

    /**
     * Gets the start or leftmost color when {@link NameStyle#getStyle()} is {@link Style#GRADIENT}.
     *
     * @return the starting {@link NameColor}
     */
    public Optional<NameColor> getStartColor() {
        return Optional.ofNullable(startColor);
    }

    /**
     * Gets the end or rightmost color when {@link NameStyle#getStyle()} is {@link Style#GRADIENT}.
     *
     * @return the ending {@link NameColor}
     */
    public Optional<NameColor> getEndColor() {
        return Optional.ofNullable(endColor);
    }

    @Override
    public String toString() {
        return "NameStyle{" +
                "style=" + style +
                ", color=" + color +
                ", startColor=" + startColor +
                ", endColor=" + endColor +
                '}';
    }
}
