package com.github.treescrub.spedran.data.user;

import com.github.treescrub.spedran.api.request.user.UserPBsRequest;
import com.github.treescrub.spedran.data.IdentifiableResource;
import com.github.treescrub.spedran.data.Link;
import com.github.treescrub.spedran.data.Names;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.util.Optional;

/**
 * Represents a user on SRC.
 */
public class User extends IdentifiableResource {
    private Names names;
    private boolean supporterAnimation;
    private String pronouns;
    private String weblink;
    private NameStyle nameStyle;
    private String role;
    private Instant signup;
    private UserLocation location;
    private Link twitch;
    private Link hitbox;
    private Link youtube;
    private Link twitter;
    private Link speedrunsLive;

    public User(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public User(JSONObject data) {
        super(data);
    }

    /**
     * Gets a new {@link UserPBsRequest} builder object to request this user's personal best runs.
     *
     * @return a {@code UserPBsRequest} builder
     */
    public UserPBsRequest getPersonalBests() {
        return new UserPBsRequest(this);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

        names = new Names(data.getJSONObject("names"));
        supporterAnimation = data.getBoolean("supporterAnimation");
        pronouns = data.isNull("pronouns") || data.getString("pronouns").isEmpty() ? null : data.getString("pronouns");
        weblink = data.getString("weblink");
        nameStyle = new NameStyle(data.getJSONObject("name-style"));
        role = data.getString("role");
        signup = data.isNull("signup") ? null : Instant.parse(data.getString("signup"));
        location = data.isNull("location") ? null : new UserLocation(data.getJSONObject("location"));
        twitch = data.isNull("twitch") ? null : new Link(data.getJSONObject("twitch"));
        hitbox = data.isNull("hitbox") ? null : new Link(data.getJSONObject("hitbox"));
        youtube = data.isNull("youtube") ? null : new Link(data.getJSONObject("youtube"));
        twitter = data.isNull("twitter") ? null : new Link(data.getJSONObject("twitter"));
        speedrunsLive = data.isNull("speedrunslive") ? null : new Link(data.getJSONObject("speedrunslive"));
    }

    /**
     * Returns the {@link Names} for this user.
     *
     * @return a {@code Names} with this user's names
     */
    public Names getNames() {
        return names;
    }

    /**
     * Returns {@code true} if this user has their name color animated, otherwise {@code false}.
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
     * Gets the role of this user.
     * <br>
     * This can be one of: {@code banned}, {@code user}, {@code trusted}, {@code moderator}, {@code admin}, or {@code programmer}.
     *
     * @return the role of this user
     */
    public String getRole() {
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
