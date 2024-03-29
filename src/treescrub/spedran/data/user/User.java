package treescrub.spedran.data.user;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.user.UserPBsRequest;
import treescrub.spedran.data.IdentifiableResource;
import treescrub.spedran.data.Link;
import treescrub.spedran.data.Names;

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
     *
     * @return
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
     * Returns the names for this user.
     *
     * @return
     */
    public Names getNames() {
        return names;
    }

    /**
     * Returns a <code>boolean</code> for the user having their name color animated.
     *
     * @return
     */
    public boolean hasSupporterAnimation() {
        return supporterAnimation;
    }

    /**
     *
     * @return an {@link Optional} containing this user's pronouns
     */
    public Optional<String> getPronouns() {
        return Optional.ofNullable(pronouns);
    }

    /**
     *
     * @return
     */
    public String getWeblink() {
        return weblink;
    }

    /**
     *
     * @return
     */
    public NameStyle getNameStyle() {
        return nameStyle;
    }

    /**
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @return
     */
    public Optional<Instant> getSignupTime() {
        return Optional.ofNullable(signup);
    }

    /**
     *
     * @return
     */
    public Optional<UserLocation> getLocation() {
        return Optional.ofNullable(location);
    }

    /**
     *
     * @return
     */
    public Optional<Link> getTwitchLink() {
        return Optional.ofNullable(twitch);
    }

    /**
     *
     * @return
     */
    public Optional<Link> getHitboxLink() {
        return Optional.ofNullable(hitbox);
    }

    /**
     *
     * @return
     */
    public Optional<Link> getYoutubeLink() {
        return Optional.ofNullable(youtube);
    }

    /**
     *
     * @return
     */
    public Optional<Link> getTwitterLink() {
        return Optional.ofNullable(twitter);
    }

    /**
     *
     * @return
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
