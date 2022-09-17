package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import treescrub.spedran.api.Utils;

import java.util.Collections;
import java.util.List;

public class GameRuleset {
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
        runTimes = Utils.getStringList(data.getJSONArray("run-times"));
        defaultTime = data.getString("default-time");
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

    public List<String> getRunTimes() {
        return Collections.unmodifiableList(runTimes);
    }

    public String getDefaultTime() {
        return defaultTime;
    }
}
