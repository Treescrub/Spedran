package treescrub.spedran.data.game;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.ParseUtils;
import treescrub.spedran.data.IdentifiableResource;
import treescrub.spedran.data.Names;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Game extends IdentifiableResource {
    private Names names;
    private Integer boostReceived;
    private Integer boostDistinctDonors;
    private String abbreviation;
    private String weblink;
    private String discord;
    private LocalDate releaseDate;
    private GameRuleset ruleset;
    private List<String> gametypes;
    private List<String> platforms;
    private List<String> regions;
    private List<String> genres;
    private List<String> engines;
    private List<String> developers;
    private List<String> publishers;
    private Map<String, String> moderators;
    private Instant created;

    public Game(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Game(JSONObject data) {
        super(data);
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        names = new Names(data.getJSONObject("names"));
        boostReceived = data.getInt("boostReceived");
        boostDistinctDonors = data.getInt("boostDistinctDonors");
        abbreviation = data.getString("abbreviation");
        weblink = data.getString("weblink");
        discord = data.getString("discord").isEmpty() ? null : data.getString("discord");
        releaseDate = LocalDate.parse(data.getString("release-date"));
        ruleset = new GameRuleset(data.getJSONObject("ruleset"));
        gametypes = ParseUtils.getStringList(data.getJSONArray("gametypes"));
        platforms = ParseUtils.getStringList(data.getJSONArray("platforms"));
        regions = ParseUtils.getStringList(data.getJSONArray("regions"));
        genres = ParseUtils.getStringList(data.getJSONArray("genres"));
        engines = ParseUtils.getStringList(data.getJSONArray("engines"));
        developers = ParseUtils.getStringList(data.getJSONArray("developers"));
        publishers = ParseUtils.getStringList(data.getJSONArray("publishers"));
        moderators = new HashMap<>();
        for(String key : data.getJSONObject("moderators").keySet()) {
            moderators.put(key, data.getJSONObject("moderators").getString(key));
        }
        if(!data.isNull("created"))
            created = Instant.parse(data.getString("created"));
    }

    public Names getNames() {
        return names;
    }

    public Integer getBoostsReceived() {
        return boostReceived;
    }

    public Integer getDistinctBoosters() {
        return boostDistinctDonors;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getWebLink() {
        return weblink;
    }

    public Optional<String> getDiscordLink() {
        return Optional.ofNullable(discord);
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Optional<GameRuleset> getRuleset() {
        return Optional.ofNullable(ruleset);
    }

    public List<String> getGametypes() {
        return Collections.unmodifiableList(gametypes);
    }

    public List<String> getPlatforms() {
        return Collections.unmodifiableList(platforms);
    }

    public List<String> getRegions() {
        return Collections.unmodifiableList(regions);
    }

    public List<String> getGenres() {
        return Collections.unmodifiableList(genres);
    }

    public List<String> getEngines() {
        return Collections.unmodifiableList(engines);
    }

    public List<String> getDevelopers() {
        return Collections.unmodifiableList(developers);
    }

    public List<String> getPublishers() {
        return Collections.unmodifiableList(publishers);
    }

    public Map<String, String> getModerators() {
        return Collections.unmodifiableMap(moderators);
    }

    public Optional<Instant> getCreationTime() {
        return Optional.ofNullable(created);
    }
}
