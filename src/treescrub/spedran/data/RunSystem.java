package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

public class RunSystem {
    private String platform;
    private boolean emulated;
    private String region;

    public RunSystem(JSONObject data) {
        platform = data.getString("platform");
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
}
