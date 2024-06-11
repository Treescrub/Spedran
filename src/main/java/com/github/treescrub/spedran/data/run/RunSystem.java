package com.github.treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Contains platform and region info, as well as if the run used an emulator.
 *
 * @see com.github.treescrub.spedran.data.Platform
 * @see com.github.treescrub.spedran.data.Region
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
     * Gets the platform ID that this run was played on
     *
     * @return the platform ID
     *
     * @see com.github.treescrub.spedran.data.Platform
     * @see com.github.treescrub.spedran.api.Spedran#getPlatform(String)
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Was the run played on an emulator.
     *
     * @return whether the run was played on emulator
     */
    public boolean isEmulated() {
        return emulated;
    }

    /**
     * Gets the region ID that this run was played on
     *
     * @return an {@link Optional} with the region ID if applicable
     *
     * @see com.github.treescrub.spedran.data.Region
     * @see com.github.treescrub.spedran.api.Spedran#getRegion(String)
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
