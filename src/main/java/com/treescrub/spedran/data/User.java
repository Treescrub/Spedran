package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import com.treescrub.spedran.requests.builders.game.GamesRequest;
import com.treescrub.spedran.requests.builders.run.RunsRequest;
import com.treescrub.spedran.requests.builders.user.UserPBsRequest;
import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.util.Optional;

/**
 * Represents a user on SRC.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class User extends IdentifiableResource {
    private final Names names;
    private final boolean supporterAnimation;
    private final String pronouns;
    private final String weblink;
    private final NameStyle nameStyle;
    private final UserRole role;
    private final Instant signup;
    private final UserLocation location;
    private final Link twitch;
    private final Link hitbox;
    private final Link youtube;
    private final Link twitter;
    private final Link speedrunsLive;
    private final UserAssets assets;

    User(JSONObject data) {
        super(data);

        names = new Names(data.getJSONObject("names"));
        supporterAnimation = data.getBoolean("supporterAnimation");
        pronouns = data.isNull("pronouns") || data.getString("pronouns").isEmpty() ? null : data.getString("pronouns");
        weblink = data.getString("weblink");
        nameStyle = new NameStyle(data.getJSONObject("name-style"));
        role = UserRole.valueOf(data.getString("role").toUpperCase());
        signup = data.isNull("signup") ? null : Instant.parse(data.getString("signup"));
        location = data.isNull("location") ? null : new UserLocation(data.getJSONObject("location"));
        twitch = data.isNull("twitch") ? null : new Link(data.getJSONObject("twitch"));
        hitbox = data.isNull("hitbox") ? null : new Link(data.getJSONObject("hitbox"));
        youtube = data.isNull("youtube") ? null : new Link(data.getJSONObject("youtube"));
        twitter = data.isNull("twitter") ? null : new Link(data.getJSONObject("twitter"));
        speedrunsLive = data.isNull("speedrunslive") ? null : new Link(data.getJSONObject("speedrunslive"));
        assets = new UserAssets(data.getJSONObject("assets"));
    }

    /**
     * Gets a new {@link RunsRequest} builder object to request all of this user's runs.
     *
     * @return a {@code RunsRequest} builder
     */
    @SuppressWarnings("unused")
    public RunsRequest getRuns() {
        return Spedran.getRuns().user(this);
    }

    /**
     * Gets a new {@link GamesRequest} builder object to request all the games this user moderates.
     *
     * @return a {@code GamesRequest} builder
     */
    @SuppressWarnings("unused")
    public GamesRequest getGamesModerated() {
        return Spedran.getGames().moderator(this);
    }

    /**
     * Gets a new {@link UserPBsRequest} builder object to request this user's personal best runs.
     *
     * @return a {@code UserPBsRequest} builder
     */
    @SuppressWarnings("unused")
    public UserPBsRequest getPersonalBests() {
        return Spedran.getUserPBs(id);
    }

    /**
     * Gets the {@link Names} for this user.
     *
     * @return a {@code Names} with this user's names
     */
    public Names getNames() {
        return names;
    }

    /**
     * Gets whether this user has the name color supporter animation enabled.
     *
     * @return whether this user has the supporter animation
     */
    public boolean hasSupporterAnimation() {
        return supporterAnimation;
    }

    /**
     * Gets the user specified pronouns for this user.
     *
     * @return an {@link Optional} containing this user's pronouns
     */
    public Optional<String> getPronouns() {
        return Optional.ofNullable(pronouns);
    }

    /**
     * Gets the link to this user on SRC.
     *
     * @return a link to this user's profile
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     * Gets the {@link NameStyle} for this user.
     *
     * @return a {@code NameStyle} of this user
     */
    public NameStyle getNameStyle() {
        return nameStyle;
    }

    /**
     * Gets the role of this user across the entire site.
     *
     * @return the {@link UserRole} of this user on SRC itself
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Gets the time that this user signed up on SRC.
     *
     * @return an {@link Instant}
     */
    public Optional<Instant> getSignupTime() {
        return Optional.ofNullable(signup);
    }

    /**
     * Gets the location that this user specified.
     *
     * @return an {@link Optional} with a {@link UserLocation} with this user's location in the world
     */
    public Optional<UserLocation> getLocation() {
        return Optional.ofNullable(location);
    }

    /**
     * Gets the link to this user's Twitch account.
     *
     * @return an {@link Optional} with a {@link Link} to a Twitch account
     */
    public Optional<Link> getTwitchLink() {
        return Optional.ofNullable(twitch);
    }

    /**
     * Gets the link to this user's Hitbox account.
     * <br>
     * Hitbox.tv is shut down, so the returned link will not be a valid page.
     *
     * @return an {@link Optional} with a {@link Link} to a Hitbox account
     */
    public Optional<Link> getHitboxLink() {
        return Optional.ofNullable(hitbox);
    }

    /**
     * Gets the link to this user's YouTube channel.
     *
     * @return an {@link Optional} with a {@link Link} to a YouTube channel
     */
    public Optional<Link> getYoutubeLink() {
        return Optional.ofNullable(youtube);
    }

    /**
     * Gets the link to this user's Twitter account.
     *
     * @return an {@link Optional} with a {@link Link} to a Twitter account
     */
    public Optional<Link> getTwitterLink() {
        return Optional.ofNullable(twitter);
    }

    /**
     * Gets the link to this user's SpeedRunsLive account.
     *
     * @return an {@link Optional} with a {@link Link} to a SpeedRunsLive account
     */
    public Optional<Link> getSpeedrunsLiveLink() {
        return Optional.ofNullable(speedrunsLive);
    }

    /**
     * Gets the {@link UserAssets} for this user.
     *
     * @return a {@code UserAssets} object
     */
    @SuppressWarnings("unused")
    public UserAssets getAssets() {
        return assets;
    }

    @Override
    public String toString() {
        return "User[" + id + "]{" +
                "names=" + names +
                ", role='" + role + '\'' +
                ", signup=" + signup +
                ", location=" + location +
                "}";
    }
}
