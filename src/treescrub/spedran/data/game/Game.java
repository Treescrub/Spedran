package treescrub.spedran.data.game;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.game.*;
import treescrub.spedran.data.ParseUtils;
import treescrub.spedran.data.IdentifiableResource;
import treescrub.spedran.data.Names;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

/**
 *
 */
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
        super(data);
    }

    public Game(JSONObject data) {
        super(data);
    }

    /**
     *
     * @return
     */
    public GameCategoriesRequest getCategories() {
        return new GameCategoriesRequest(this);
    }

    /**
     *
     * @return
     */
    public GameLevelsRequest getLevels() {
        return new GameLevelsRequest(this);
    }

    /**
     *
     * @return
     */
    public GameRecordsRequest getRecords() {
        return new GameRecordsRequest(this);
    }

    /**
     *
     * @return
     */
    public GameRomhacksRequest getRomhacks() {
        return new GameRomhacksRequest(this);
    }

    /**
     *
     * @return
     */
    public GameVariablesRequest getVariables() {
        return new GameVariablesRequest(this);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        super.parseFromJson(data);

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
    public Integer getBoostsReceived() {
        return boostReceived;
    }

    /**
     *
     * @return
     */
    public Integer getDistinctBoosters() {
        return boostDistinctDonors;
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
    public String getWebLink() {
        return weblink;
    }

    /**
     *
     * @return
     */
    public Optional<String> getDiscordLink() {
        return Optional.ofNullable(discord);
    }

    /**
     *
     * @return
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     *
     * @return
     */
    public Optional<GameRuleset> getRuleset() {
        return Optional.ofNullable(ruleset);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getGametype(String)
     */
    public List<String> getGametypes() {
        return Collections.unmodifiableList(gametypes);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getPlatform(String)
     */
    public List<String> getPlatforms() {
        return Collections.unmodifiableList(platforms);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getRegion(String)
     */
    public List<String> getRegions() {
        return Collections.unmodifiableList(regions);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getGenre(String)
     */
    public List<String> getGenres() {
        return Collections.unmodifiableList(genres);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getEngine(String)
     */
    public List<String> getEngines() {
        return Collections.unmodifiableList(engines);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getDeveloper(String)
     */
    public List<String> getDevelopers() {
        return Collections.unmodifiableList(developers);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getPublisher(String)
     */
    public List<String> getPublishers() {
        return Collections.unmodifiableList(publishers);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getUser(String)
     */
    public Map<String, String> getModerators() {
        return Collections.unmodifiableMap(moderators);
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
        return "Game[" + id + "]{" +
                "names=" + names +
                ", abbreviation='" + abbreviation + '\'' +
                ", releaseDate=" + releaseDate +
                ", created=" + created +
                "}";
    }
}
