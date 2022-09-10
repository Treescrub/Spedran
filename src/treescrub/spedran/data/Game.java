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
}

class GameModerators {
    private Map<String, String> moderators;

    public GameModerators(JSONObject data) {
        moderators = new HashMap<>();
        for(String key : data.keySet()) {
            moderators.put(key, data.getString(key));
        }
    }
}

public class Game extends Resource {
    private String id;
    private Names names;
    private Integer boostReceived;
    private Integer boostDistinctDonors;
    private String abbreviation;
    private URL weblink;
    private URL discord;
    private LocalDate releaseDate;
    private GameRuleset ruleset;
    private List<Gametype> gametypes;
    private List<Platform> platforms;
    private List<Region> regions;
    private List<Genre> genres;
    private List<Engine> engines;
    private List<Developer> developers;
    private List<Publisher> publishers;
    private Map<String, String> moderators;
    private Instant created;

    public Game(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Game(JSONObject data) {
        gametypes = new ArrayList<>();
        platforms = new ArrayList<>();
        regions = new ArrayList<>();
        genres = new ArrayList<>();
        engines = new ArrayList<>();
        developers = new ArrayList<>();
        publishers = new ArrayList<>();
        moderators = new HashMap<>();

        id = data.getString("id");
        names = new Names(data.getJSONObject("names"));
        boostReceived = data.getInt("boostReceived");
        boostDistinctDonors = data.getInt("boostDistinctDonors");
        abbreviation = data.getString("abbreviation");
        try {
            weblink = new URL(data.getString("weblink"));
            discord = data.getString("discord").isEmpty() ? null : new URL(data.getString("discord"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        releaseDate = LocalDate.parse(data.getString("release-date"));
        ruleset = new GameRuleset(data.getJSONObject("ruleset"));
        // TODO: gametypes
        // TODO: platforms
        // TODO: regions
        // TODO: genres
        // TODO: engines
        // TODO: developers
        // TODO: publishers
        for(String key : data.getJSONObject("moderators").keySet()) {
            moderators.put(key, data.getJSONObject("moderators").getString(key));
        }
        created = data.isNull("created") ? null : Instant.parse(data.getString("created"));
    }

    public String getId() {
        return id;
    }

    public Optional<Names> getNames() {
        return Optional.ofNullable(names);
    }

    public Optional<Integer> getBoostsReceived() {
        return Optional.ofNullable(boostReceived);
    }

    public Optional<Integer> getDistinctBoosters() {
        return Optional.ofNullable(boostDistinctDonors);
    }

    public Optional<String> getAbbreviation() {
        return Optional.ofNullable(abbreviation);
    }

    public Optional<URL> getWebLink() {
        return Optional.ofNullable(weblink);
    }

    public Optional<URL> getDiscordLink() {
        return Optional.ofNullable(discord);
    }

    public Optional<LocalDate> getReleaseDate() {
        return Optional.ofNullable(releaseDate);
    }

    public Optional<GameRuleset> getRuleset() {
        return Optional.ofNullable(ruleset);
    }
}
