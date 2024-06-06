package com.github.treescrub.spedran.data.game;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.api.request.game.*;
import com.github.treescrub.spedran.data.ParseUtils;
import com.github.treescrub.spedran.data.IdentifiableResource;
import com.github.treescrub.spedran.data.Names;

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
     * @return a Names describing this game's names
     */
    public Names getNames() {
        return names;
    }

    /**
     *
     *
     * @return times this game has been boosted
     * @see <a href="https://www.speedrun.com/supporter/faq">SRC Supporter FAQ</a>
     */
    public Integer getBoostsReceived() {
        return boostReceived;
    }

    /**
     *
     *
     * @return total unique users that have boosted this game
     * @see <a href="https://www.speedrun.com/supporter/faq">SRC Supporter FAQ</a>
     */
    public Integer getDistinctBoosters() {
        return boostDistinctDonors;
    }

    /**
     *
     * @return the shortened game title
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     *
     *
     * @return a link to this game on SRC
     */
    public String getWebLink() {
        return weblink;
    }

    /**
     *
     * @return an {@link Optional} with an invitation link to this game's Discord server
     */
    public Optional<String> getDiscordLink() {
        return Optional.ofNullable(discord);
    }

    /**
     *
     * @return a LocalDate describing when this game was released
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     *
     * @return an {@link Optional} with a {@link GameRuleset}
     */
    public Optional<GameRuleset> getRuleset() {
        return Optional.ofNullable(ruleset);
    }

    /**
     *
     * @return a List of gametype IDs
     * @see com.github.treescrub.spedran.api.Spedran#getGametype(String)
     */
    public List<String> getGametypes() {
        return Collections.unmodifiableList(gametypes);
    }

    /**
     *
     * @return a List of platform IDs
     * @see com.github.treescrub.spedran.api.Spedran#getPlatform(String)
     */
    public List<String> getPlatforms() {
        return Collections.unmodifiableList(platforms);
    }

    /**
     *
     * @return a List of region IDs
     * @see com.github.treescrub.spedran.api.Spedran#getRegion(String)
     */
    public List<String> getRegions() {
        return Collections.unmodifiableList(regions);
    }

    /**
     *
     * @return a List of genre IDs
     * @see com.github.treescrub.spedran.api.Spedran#getGenre(String)
     */
    public List<String> getGenres() {
        return Collections.unmodifiableList(genres);
    }

    /**
     *
     * @return a List of engine IDs
     * @see com.github.treescrub.spedran.api.Spedran#getEngine(String)
     */
    public List<String> getEngines() {
        return Collections.unmodifiableList(engines);
    }

    /**
     *
     * @return a List of developer IDs
     * @see com.github.treescrub.spedran.api.Spedran#getDeveloper(String)
     */
    public List<String> getDevelopers() {
        return Collections.unmodifiableList(developers);
    }

    /**
     *
     * @return a List of publisher IDs
     * @see com.github.treescrub.spedran.api.Spedran#getPublisher(String)
     */
    public List<String> getPublishers() {
        return Collections.unmodifiableList(publishers);
    }

    /**
     *
     * @return a Map of user IDs to moderator types
     * @see com.github.treescrub.spedran.api.Spedran#getUser(String)
     */
    public Map<String, String> getModerators() {
        return Collections.unmodifiableMap(moderators);
    }

    /**
     * Returns an Instant with the exact time this game was added to SRC.
     * <p>
     * Games added before this field was implemented will return an empty Optional.
     *
     * @return an {@link Optional} Instant describing when this game was added to SRC
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
