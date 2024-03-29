package treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Username styling info.
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
     *
     * @return
     */
    public Style getStyle() {
        return style;
    }

    /**
     *
     * @return
     */
    public Optional<NameColor> getColor() {
        return Optional.ofNullable(color);
    }

    /**
     *
     * @return
     */
    public Optional<NameColor> getStartColor() {
        return Optional.ofNullable(startColor);
    }

    /**
     *
     * @return
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
