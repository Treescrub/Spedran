package com.github.treescrub.spedran.data.game;

import com.github.treescrub.spedran.data.Link;
import kong.unirest.json.JSONObject;

import java.util.Optional;

public class GameAssets {
    private final Link logo;
    private final Link tinyCover;
    private final Link smallCover;
    private final Link mediumCover;
    private final Link largeCover;
    private final Link icon;
    private final Link firstTrophy;
    private final Link secondTrophy;
    private final Link thirdTrophy;
    private final Link fourthTrophy;
    private final Link background;
    private final Link foreground;

    public GameAssets(JSONObject data) {
        logo = new Link(data.getJSONObject("logo"));
        tinyCover = new Link(data.getJSONObject("cover-tiny"));
        smallCover = new Link(data.getJSONObject("cover-small"));
        mediumCover = new Link(data.getJSONObject("cover-medium"));
        largeCover = new Link(data.getJSONObject("cover-large"));
        icon = new Link(data.getJSONObject("icon"));
        firstTrophy = new Link(data.getJSONObject("trophy-1st"));
        secondTrophy = new Link(data.getJSONObject("trophy-2nd"));
        thirdTrophy = new Link(data.getJSONObject("trophy-3rd"));
        fourthTrophy = getLinkOrNull(data.getJSONObject("trophy-4th"));
        background = getLinkOrNull(data.getJSONObject("background"));
        foreground = getLinkOrNull(data.getJSONObject("foreground"));
    }

    private static Link getLinkOrNull(JSONObject data) {
        if(Link.isEmpty(data)) {
            return null;
        } else {
            return new Link(data);
        }
    }

    /**
     * Gets a {@link Link} to the Speedrun.com logo at the top left.
     *
     * @return a {@code Link} to an image
     */
    public Link getLogo() {
        return logo;
    }

    /**
     * Gets a {@link Link} to the "tiny" size version of the cover art for the game or series.
     *
     * @return a {@code Link} to an image
     */
    public Link getTinyCover() {
        return tinyCover;
    }

    /**
     * Gets a {@link Link} to the "small" size version of the cover art for the game or series.
     *
     * @return a {@code Link} to an image
     */
    public Link getSmallCover() {
        return smallCover;
    }

    /**
     * Gets a {@link Link} to the "medium" size version of the cover art for the game or series.
     *
     * @return a {@code Link} to an image
     */
    public Link getMediumCover() {
        return mediumCover;
    }

    /**
     * Gets a {@link Link} to the "large" size version of the cover art for the game or series.
     *
     * @return a {@code Link} to an image
     */
    public Link getLargeCover() {
        return largeCover;
    }

    /**
     * Gets a {@link Link} to the icon that is shown on the browser tab.
     *
     * @return a {@code Link} to an image
     */
    public Link getIcon() {
        return icon;
    }

    /**
     * Gets a {@link Link} to the trophy icon that is shown next to the first place run.
     *
     * @return a {@code Link} to an image
     */
    public Link getFirstTrophy() {
        return firstTrophy;
    }

    /**
     * Gets a {@link Link} to the trophy icon that is shown next to the second place run.
     *
     * @return a {@code Link} to an image
     */
    public Link getSecondTrophy() {
        return secondTrophy;
    }

    /**
     * Gets a {@link Link} to the trophy icon that is shown next to the third place run.
     *
     * @return a {@code Link} to an image
     */
    public Link getThirdTrophy() {
        return thirdTrophy;
    }

    /**
     * Gets a {@link Link} to the trophy icon that is shown next to the fourth place run.
     *
     * @return an {@link Optional} with a {@code Link} to an image, empty if a custom image is not set
     */
    public Optional<Link> getFourthTrophy() {
        return Optional.ofNullable(fourthTrophy);
    }

    /**
     * Gets a {@link Link} to the background image.
     *
     * @return an {@link Optional} with a {@code Link} to an image, empty if a custom image is not set
     */
    public Optional<Link> getBackground() {
        return Optional.ofNullable(background);
    }

    /**
     * Gets a {@link Link} to the foreground image.
     *
     * @return an {@link Optional} with a {@code Link} to an image, empty if a custom image is not set
     */
    public Optional<Link> getForeground() {
        return Optional.ofNullable(foreground);
    }
}
