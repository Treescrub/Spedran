package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Has info about platform and region for a run.
 */
public class RunSystem {
    private String platform;
    private boolean emulated;
    private String region;

    public RunSystem(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        platform = data.optString("platform", null);
        emulated = data.getBoolean("emulated");
        region = data.optString("region", null);
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getPlatform(String)
     */
    public String getPlatform() {
        return platform;
    }

    /**
     *
     * @return
     */
    public boolean isEmulated() {
        return emulated;
    }

    /**
     *
     * @return
     * @see treescrub.spedran.api.Spedran#getRegion(String)
     */
    public Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }

    @Override
    public String toString() {
        return "RunSystem{" +
                "platform='" + platform + '\'' +
                ", emulated=" + emulated +
                ", region='" + region + '\'' +
                '}';
    }
}
