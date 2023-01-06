package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;

import java.util.Optional;

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

    public String getPlatform() {
        return platform;
    }

    public boolean isEmulated() {
        return emulated;
    }

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
