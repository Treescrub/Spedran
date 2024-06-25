package com.github.treescrub.spedran.api.request.run;

import com.github.treescrub.spedran.api.request.InvalidBuilderStateException;
import com.github.treescrub.spedran.api.request.ModifyResourceRequest;
import com.github.treescrub.spedran.data.Guest;
import com.github.treescrub.spedran.data.Level;
import com.github.treescrub.spedran.data.Platform;
import com.github.treescrub.spedran.data.Region;
import com.github.treescrub.spedran.data.category.Category;
import com.github.treescrub.spedran.data.run.Run;
import com.github.treescrub.spedran.data.user.User;
import com.github.treescrub.spedran.data.variables.Variable;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONElement;
import kong.unirest.json.JSONObject;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubmitRunRequest extends ModifyResourceRequest<Run> {
    private enum VariableType {
        USER_DEFINED,
        PREDEFINED,
    }

    private static class RunVariable {
        VariableType type;
        String value;

        public RunVariable(VariableType type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    private String categoryId;
    private String levelId;
    private LocalDate date;
    private String regionId;
    private String platformId;
    private boolean verified;
    private final Map<String, Duration> times;
    private final Map<String, String> players;
    private boolean isEmulated;
    private String videoUrl;
    private String comment;
    private String splitsIO;
    private final Map<String, RunVariable> variables;

    public SubmitRunRequest() {
        super(HttpMethod.POST, "runs");

        verified = false;
        times = new HashMap<>();
        players = new LinkedHashMap<>();
        isEmulated = false;
        variables = new HashMap<>();
    }

    /**
     * Sets the {@link Category} for the run.
     *
     * @param category the category that the run is in
     * @return this builder object
     */
    public SubmitRunRequest category(Category category) {
        return category(category.getId());
    }

    /**
     * Sets the {@link Category} for the run.
     *
     * @param categoryId the category ID that the run is in
     * @return this builder object
     */
    public SubmitRunRequest category(String categoryId) {
        this.categoryId = categoryId;

        return this;
    }

    /**
     * Sets the {@link Level} for the run.
     *
     * @param level the level that the run is on
     * @return this builder object
     */
    public SubmitRunRequest level(Level level) {
        return level(level.getId());
    }

    /**
     * Sets the {@link Level} for the run.
     *
     * @param levelId the level ID that the run is on
     * @return this builder object
     */
    public SubmitRunRequest level(String levelId) {
        this.levelId = levelId;

        return this;
    }

    /**
     * Sets the date that this run was played on.
     *
     * @param runDate the date this run was ran on
     * @return this builder object
     */
    public SubmitRunRequest date(LocalDate runDate) {
        this.date = runDate;

        return this;
    }

    /**
     * Sets the {@link Region} game version for the run.
     *
     * @param region the region of the game for the run
     * @return this builder object
     */
    public SubmitRunRequest region(Region region) {
        return region(region.getId());
    }

    /**
     * Sets the {@link Region} game version for the run.
     *
     * @param regionId the region ID of the game for the run
     * @return this builder object
     */
    public SubmitRunRequest region(String regionId) {
        this.regionId = regionId;

        return this;
    }

    /**
     * Sets the {@link Platform} for the run.
     *
     * @param platform the platform that this run was played on
     * @return this builder object
     */
    public SubmitRunRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    /**
     * Sets the {@link Platform} for the run.
     *
     * @param platformId the platform ID that this run was played on
     * @return this builder object
     */
    public SubmitRunRequest platform(String platformId) {
        this.platformId = platformId;

        return this;
    }

    /**
     * Sets the run to be immediately verified when submitted.
     * <br>
     * Requires permissions to verify runs for the leaderboard that the run is being submitted to.
     *
     * @return this builder object
     */
    public SubmitRunRequest verified() {
        this.verified = true;

        return this;
    }

    /**
     * Sets the realtime (RTA) time for the run.
     *
     * @param realTime a {@link Duration} with the RTA time
     * @return this builder object
     */
    public SubmitRunRequest realTime(Duration realTime) {
        times.put("realtime", realTime);

        return this;
    }

    /**
     * Sets the realtime (RTA) with loads removed time for the run.
     *
     * @param realTimeNoLoads a {@link Duration} with the RTA no loads time
     * @return this builder object
     */
    public SubmitRunRequest realTimeNoLoads(Duration realTimeNoLoads) {
        times.put("realtime_noloads", realTimeNoLoads);

        return this;
    }

    /**
     * Sets the ingame time (IGT) for the run.
     *
     * @param ingameTime a {@link Duration} with the ingame time
     * @return this builder object
     */
    public SubmitRunRequest ingameTime(Duration ingameTime) {
        times.put("ingame", ingameTime);

        return this;
    }

    /**
     * Adds a {@link User} that participated in the run.
     *
     * @param user a user that is a player in the run
     * @return this builder object
     */
    public SubmitRunRequest userPlayer(User user) {
        return userPlayer(user.getId());
    }

    /**
     * Adds a {@link User} that participated in the run.
     *
     * @param userId the ID of a user that is a player in the run
     * @return this builder object
     */
    public SubmitRunRequest userPlayer(String userId) {
        players.put(userId, "user");

        return this;
    }

    /**
     * Adds a {@link Guest} that participated in the run.
     *
     * @param guest a guest that is a player in the run
     * @return this builder object
     */
    public SubmitRunRequest guestPlayer(Guest guest) {
        return guestPlayer(guest.getName());
    }

    /**
     * Adds a {@link Guest} that participated in the run.
     *
     * @param guestName the name of a guest that is a player in the run
     * @return this builder object
     */
    public SubmitRunRequest guestPlayer(String guestName) {
        players.put(guestName, "guest");

        return this;
    }

    /**
     * Sets whether the run was played on an emulator.
     *
     * @param isEmulated whether an emulator was used
     * @return this builder object
     */
    public SubmitRunRequest emulated(boolean isEmulated) {
        this.isEmulated = isEmulated;

        return this;
    }

    /**
     * Sets the video URL for the run.
     *
     * @param videoUrl a {@code String} with a URL to a video hosting site
     * @return this builder object
     */
    public SubmitRunRequest video(String videoUrl) {
        this.videoUrl = videoUrl;

        return this;
    }

    /**
     * Sets the comment/description for the run.
     *
     * @param comment a {@code String} with the custom comment
     * @return this builder object
     */
    public SubmitRunRequest comment(String comment) {
        this.comment = comment;

        return this;
    }

    /**
     * Sets the ID or URL for the splits.io run page.
     *
     * @param splitsIO a {@code String} with an ID or URL to a splits.io page
     * @return this builder object
     */
    public SubmitRunRequest splitsIO(String splitsIO) {
        this.splitsIO = splitsIO;

        return this;
    }

    /**
     * Sets the value for a {@link Variable} with a predefined value ID.
     *
     * @param variable the variable to set for the run
     * @param valueId the value ID to set for the variable
     * @return this builder object
     */
    public SubmitRunRequest variable(Variable variable, String valueId) {
        return variable(variable.getId(), valueId);
    }

    /**
     * Sets the value for a {@link Variable} with a predefined value ID.
     *
     * @param variableId the variable ID to set for the run
     * @param valueId the value ID to set for the variable
     * @return this builder object
     */
    public SubmitRunRequest variable(String variableId, String valueId) {
        this.variables.put(variableId, new RunVariable(VariableType.PREDEFINED, valueId));

        return this;
    }

    /**
     * Sets the value for a {@link Variable} with custom user defined text.
     *
     * @param variable the variable to set for the run
     * @param valueText the value to set for the variable
     * @return this builder object
     */
    public SubmitRunRequest customVariable(Variable variable, String valueText) {
        return customVariable(variable.getId(), valueText);
    }

    /**
     * Sets the value for a {@link Variable} with custom user defined text.
     *
     * @param variableId the variable ID to set for the run
     * @param valueText the value to set for the variable
     * @return this builder object
     */
    public SubmitRunRequest customVariable(String variableId, String valueText) {
        this.variables.put(variableId, new RunVariable(VariableType.USER_DEFINED, valueText));

        return this;
    }

    @Override
    protected Run parse(JSONObject data) {
        return new Run(data);
    }

    @Override
    protected JSONElement buildBody() throws InvalidBuilderStateException {
        if(categoryId == null) {
            throw new InvalidBuilderStateException("Missing required category");
        }
        if(platformId == null) {
            throw new InvalidBuilderStateException("Missing required platform");
        }
        if(times.isEmpty()) {
            throw new InvalidBuilderStateException("Missing run time, must have at least one set");
        }

        JSONObject runNode = new JSONObject();
        runNode.put("category", categoryId);
        if(levelId != null) {
            runNode.put("level", levelId);
        }
        if(date != null) {
            runNode.put("date", date);
        }
        if(regionId != null) {
            runNode.put("region", regionId);
        }
        runNode.put("platform", platformId);
        runNode.put("verified", verified);

        JSONObject timesNode = new JSONObject();
        for(Map.Entry<String, Duration> entry : times.entrySet()) {
            Duration duration = entry.getValue();
            double seconds = duration.toSeconds();
            double milliseconds = duration.toMillisPart();

            double time = seconds + (milliseconds / 1000);

            timesNode.put(entry.getKey(), time);
        }

        runNode.put("times", timesNode);
        if(!players.isEmpty()) {
            JSONArray playersNode = new JSONArray();

            for(Map.Entry<String, String> entry : players.entrySet()) {
                JSONObject playerNode = new JSONObject();

                String id = entry.getKey();
                String type = entry.getValue();

                playerNode.put("rel", type);

                String idKeyName;
                if(type.equals("user")) {
                    idKeyName = "id";
                } else {
                    idKeyName = "name";
                }

                playerNode.put(idKeyName, id);
                playersNode.put(playerNode);
            }

            runNode.put("players", playersNode);
        }
        runNode.put("emulated", isEmulated);
        if(videoUrl != null) {
            runNode.put("video", videoUrl);
        }
        if(comment != null) {
            runNode.put("comment", comment);
        }
        if(splitsIO != null) {
            runNode.put("splitsio", splitsIO);
        }
        JSONObject variablesNode = new JSONObject();
        for(Map.Entry<String, RunVariable> entry : variables.entrySet()) {
            JSONObject variableNode = new JSONObject();

            if(entry.getValue().type == VariableType.PREDEFINED) {
                variableNode.put("type", "pre-defined");
            } else {
                variableNode.put("type", "user-defined");
            }
            variableNode.put("value", entry.getValue().value);

            variablesNode.put(entry.getKey(), variableNode);
        }
        runNode.put("variables", variablesNode);

        JSONObject rootNode = new JSONObject();
        rootNode.put("run", runNode);

        return rootNode;
    }
}
