package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Series {
    private String id;
    private Names names;
    private String abbreviation;
    private String weblink;
    private String discord;
    private Map<String, String> moderators;
    private Instant created;

    public Series(JSONObject data) {
        id = data.getString("id");
        names = new Names(data.getJSONObject("names"));
        abbreviation = data.getString("abbreviation");
        weblink = data.getString("weblink");
        discord = data.optString("discord", null);
        moderators = new HashMap<>();
        for(String key : data.getJSONObject("moderators").keySet()) {
            moderators.put(key, data.getJSONObject("moderators").getString(key));
        }
        if(!data.isNull("created"))
            created = Instant.parse(data.getString("created"));
    }

    public String getId() {
        return id;
    }

    public Names getNames() {
        return names;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getWeblink() {
        return weblink;
    }

    public Optional<String> getDiscord() {
        return Optional.ofNullable(discord);
    }

    public Map<String, String> getModerators() {
        return moderators;
    }

    public Optional<Instant> getCreated() {
        return Optional.ofNullable(created);
    }
}
