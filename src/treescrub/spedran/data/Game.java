package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

class GameRuleset {
    private boolean showMilliseconds;
    private boolean requireVerification;
    private boolean requireVideo;
    private List<String> runTimes;
    private String defaultTime;
    private boolean emulatorsAllowed;

    public GameRuleset(JSONObject data) {
        showMilliseconds = data.getBoolean("show-milliseconds");
        requireVerification = data.getBoolean("require-verification");
        requireVideo = data.getBoolean("require-video");
        runTimes = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("run-times").length(); i++) {
            runTimes.add(data.getJSONArray("run-times").getString(i));
        }
        defaultTime = data.getString("default-time");
        emulatorsAllowed = data.getBoolean("emulators-allowed");
    }

    public boolean isShowMilliseconds() {
        return showMilliseconds;
    }

    public boolean isRequireVerification() {
        return requireVerification;
    }

    public boolean isRequireVideo() {
        return requireVideo;
    }

    public List<String> getRunTimes() {
        return Collections.unmodifiableList(runTimes);
    }

    public String getDefaultTime() {
        return defaultTime;
    }

    public boolean isEmulatorsAllowed() {
        return emulatorsAllowed;
    }
}

public class Game extends Resource {
    private String id;
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
        id = data.getString("id");
        names = new Names(data.getJSONObject("names"));
        boostReceived = data.getInt("boostReceived");
        boostDistinctDonors = data.getInt("boostDistinctDonors");
        abbreviation = data.getString("abbreviation");
        weblink = data.getString("weblink");
        discord = data.getString("discord").isEmpty() ? null : data.getString("discord");
        releaseDate = LocalDate.parse(data.getString("release-date"));
        ruleset = new GameRuleset(data.getJSONObject("ruleset"));
        gametypes = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("gametypes").length(); i++) {
            gametypes.add(data.getJSONArray("gametypes").getString(i));
        }
        platforms = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("platforms").length(); i++) {
            platforms.add(data.getJSONArray("platforms").getString(i));
        }
        regions = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("regions").length(); i++) {
            regions.add(data.getJSONArray("regions").getString(i));
        }
        genres = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("genres").length(); i++) {
            genres.add(data.getJSONArray("genres").getString(i));
        }
        engines = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("engines").length(); i++) {
            engines.add(data.getJSONArray("engines").getString(i));
        }
        developers = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("developers").length(); i++) {
            developers.add(data.getJSONArray("developers").getString(i));
        }
        publishers = new ArrayList<>();
        for(int i = 0; i < data.getJSONArray("publishers").length(); i++) {
            publishers.add(data.getJSONArray("publishers").getString(i));
        }
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

    public Instant getCreationTime() {
        return created;
    }
}
