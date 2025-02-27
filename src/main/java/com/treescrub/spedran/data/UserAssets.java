package com.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * A collection of {@link Link}s to custom icon and avatar images for a {@link User}.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class UserAssets {
    private final Link icon;
    private final Link supporterIcon;
    private final Link avatar;

    UserAssets(JSONObject data) {
        icon = Link.getLinkOrNull(data.getJSONObject("icon"));
        supporterIcon = data.isNull("supporterIcon") ? null : Link.getLinkOrNull(data.getJSONObject("supporterIcon"));
        avatar = Link.getLinkOrNull(data.getJSONObject("image"));
    }

    /**
     * Gets a {@link Link} to the user's custom icon.
     * <br><br>
     * The icon is shown next to the username on the user's profile, on comments, and on forum posts.
     *
     * @return an {@link Optional} with a {@code Link} to an image, empty if a custom image is not set
     */
    @SuppressWarnings("unused")
    public Optional<Link> getIcon() {
        return Optional.ofNullable(icon);
    }

    /**
     * Gets a {@link Link} to the user's custom supporter icon.
     * <br><br>
     * The supporter icon is a second icon next to the username.
     *
     * @return an {@link Optional} with a {@code Link} to an image, empty if a custom image is not set
     */
    @SuppressWarnings("unused")
    public Optional<Link> getSupporterIcon() {
        return Optional.ofNullable(supporterIcon);
    }

    /**
     * Gets a {@link Link} to the user's custom avatar.
     *
     * @return an {@link Optional} with a {@code Link} to an image, empty if a custom image is not set
     */
    @SuppressWarnings("unused")
    public Optional<Link> getAvatar() {
        return Optional.ofNullable(avatar);
    }
}
