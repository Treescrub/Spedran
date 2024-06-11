package com.github.treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Describes how the name for a {@link User} should be colored.
 * <br>
 * If the style is a gradient, {@link NameStyle#getStartColor()} and {@link NameStyle#getEndColor()} can be identical.
 */
public class NameStyle {
    public enum Style {
        SOLID,
        GRADIENT,
    }

    private Style style;
    private NameColor color;
    private NameColor startColor;
    private NameColor endColor;

    public NameStyle(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        style = Style.valueOf(data.getString("style").toUpperCase());
        if (style == Style.SOLID) {
            color = new NameColor(data.getJSONObject("color"));
        } else {
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
     * Gets the start or rightmost color when {@link NameStyle#getStyle()} is {@link Style#GRADIENT}.
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
