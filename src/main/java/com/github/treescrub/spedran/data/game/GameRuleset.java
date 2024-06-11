package com.github.treescrub.spedran.data.game;

import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.data.run.TimingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A set of moderator specified rules that define how runs can be submitted for a specific {@link Game}.
 * These are not rules in the sense of moderating the leaderboard, but rather as restrictions when submitting a run.
 */
public class GameRuleset {
    private boolean showMilliseconds;
    private boolean requireVerification;
    private boolean requireVideo;
    private List<TimingType> runTimes;
    private TimingType defaultTime;
    private boolean emulatorsAllowed;

    public GameRuleset(JSONObject data) {
        runTimes = new ArrayList<>();
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        showMilliseconds = data.getBoolean("show-milliseconds");
        requireVerification = data.getBoolean("require-verification");
        requireVideo = data.getBoolean("require-video");
        for(Object element : data.getJSONArray("run-times")) {
            String timingType = (String) element;
            runTimes.add(TimingType.valueOf(timingType.toUpperCase()));
        }
        defaultTime = TimingType.valueOf(data.getString("default-time").toUpperCase());
        emulatorsAllowed = data.getBoolean("emulators-allowed");
    }

    /**
     * Returns {@code true} if milliseconds are shown on the leaderboard, otherwise {@code false}.
     *
     * @return whether milliseconds are displayed on runs
     */
    public boolean areMillisecondsShown() {
        return showMilliseconds;
    }

    /**
     * Returns {@code true} if a run needs to be verified before it appears on the leaderboard.
     *
     * @return whether verification of a run is required
     */
    public boolean isVerificationRequired() {
        return requireVerification;
    }

    /**
     * Returns {@code true} if a video link is required, otherwise {@code false}.
     *
     * @return whether a video of a run is required
     */
    public boolean isVideoRequired() {
        return requireVideo;
    }

    /**
     * Returns {@code true} if emulators are allowed to be used in runs, otherwise {@code false}.
     *
     * @return whether emulators are allowed in a run
     */
    public boolean areEmulatorsAllowed() {
        return emulatorsAllowed;
    }

    /**
     * Gets a {@code List} of allowed {@link TimingType}s that a run can have.
     *
     * @return a {@code List} of {@code TimingType}s
     */
    public List<TimingType> getRunTimes() {
        return Collections.unmodifiableList(runTimes);
    }

    /**
     * Gets the default {@link TimingType} that this game uses to sort the leaderboard by.
     *
     * @return the {@code TimingType} that runs are sorted by
     */
    public TimingType getDefaultTime() {
        return defaultTime;
    }

    @Override
    public String toString() {
        return "GameRuleset{" +
                "showMilliseconds=" + showMilliseconds +
                ", requireVerification=" + requireVerification +
                ", requireVideo=" + requireVideo +
                ", defaultTime='" + defaultTime + '\'' +
                ", runTimes=" + runTimes +
                '}';
    }
}
