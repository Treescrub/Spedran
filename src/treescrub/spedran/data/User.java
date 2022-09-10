package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

class NameStyle {
    NameStyle(JSONObject data) {

    }
}

class UserLocation {
    UserLocation(JSONObject data) {

    }
}

public class User extends Resource {
    private Names names;
    private Boolean supporterAnimation;
    private String pronouns;
    private URL weblink;
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
        names = new Names(data.getJSONObject("names"));
        supporterAnimation = data.getBoolean("supporterAnimation");
        pronouns = data.getString("pronouns");
        try {
            weblink = new URL(data.getString("weblink"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        nameStyle = new NameStyle(data.getJSONObject("name-style"));
        role = data.getString("role");
        signup = Instant.parse(data.getString("signup"));
        location = new UserLocation(data.getJSONObject("location"));
        twitch = new Link(data.getJSONObject("twitch"));
        hitbox = new Link(data.getJSONObject("hitbox"));
        youtube = new Link(data.getJSONObject("youtube"));
        twitter = new Link(data.getJSONObject("twitter"));
        speedrunsLive = new Link(data.getJSONObject("speedrunslive"));
    }
}
