package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.series.SeriesGamesRequest;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 */
public class Series extends IdentifiableResource {
    private Names names;
    private String abbreviation;
    private String weblink;
    private String discord;
    private Map<String, String> moderators;
    private Instant created;

    public Series(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Series(JSONObject data) {
        super(data);
    }

    public SeriesGamesRequest getGames() {
        return new SeriesGamesRequest(this);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

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

    /**
     *
     * @return
     */
    public Names getNames() {
        return names;
    }

    /**
     *
     * @return
     */
    public String getAbbreviation() {
        return abbreviation;
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
    public Optional<String> getDiscord() {
        return Optional.ofNullable(discord);
    }

    /**
     *
     * @return
     */
    public Map<String, String> getModerators() {
        return moderators;
    }

    /**
     *
     * @return
     */
    public Optional<Instant> getCreationTime() {
        return Optional.ofNullable(created);
    }

    @Override
    public String toString() {
        return "Series[" + id + "]{" +
                "names=" + names +
                ", abbreviation='" + abbreviation + '\'' +
                ", created=" + created +
                "}";
    }
}
