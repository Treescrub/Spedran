package treescrub.spedran.data.game;

import kong.unirest.json.JSONObject;
import treescrub.spedran.data.run.TimingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRuleset {
    private boolean showMilliseconds;
    private boolean requireVerification;
    private boolean requireVideo;
    private List<TimingType> runTimes;
    private TimingType defaultTime;
    private boolean emulatorsAllowed;

    public GameRuleset(JSONObject data) {
        parseFromJson(data);
        runTimes = new ArrayList<>();
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

    public boolean areMillisecondsShown() {
        return showMilliseconds;
    }

    public boolean isVerificationRequired() {
        return requireVerification;
    }

    public boolean isVideoRequired() {
        return requireVideo;
    }

    public boolean areEmulatorsAllowed() {
        return emulatorsAllowed;
    }

    public List<TimingType> getRunTimes() {
        return Collections.unmodifiableList(runTimes);
    }

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
