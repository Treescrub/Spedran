package com.github.treescrub.spedran.data.game;

import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.data.run.TimingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
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
     *
     * @return
     */
    public boolean areMillisecondsShown() {
        return showMilliseconds;
    }

    /**
     *
     * @return
     */
    public boolean isVerificationRequired() {
        return requireVerification;
    }

    /**
     *
     * @return
     */
    public boolean isVideoRequired() {
        return requireVideo;
    }

    /**
     *
     * @return
     */
    public boolean areEmulatorsAllowed() {
        return emulatorsAllowed;
    }

    /**
     *
     * @return
     */
    public List<TimingType> getRunTimes() {
        return Collections.unmodifiableList(runTimes);
    }

    /**
     *
     * @return
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
