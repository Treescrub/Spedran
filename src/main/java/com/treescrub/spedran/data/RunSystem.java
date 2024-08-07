package com.treescrub.spedran.data;

import com.treescrub.spedran.Spedran;
import kong.unirest.json.JSONObject;

import java.util.Optional;

/**
 * Contains platform and region info, as well as if the run used an emulator.
 * <br><br>
 * This class is immutable and thread-safe.
 *
 * @see Platform
 * @see Region
 */
public class RunSystem {
    private final String platform;
    private final boolean emulated;
    private final String region;

    RunSystem(JSONObject data) {
        platform = data.optString("platform", null);
        emulated = data.getBoolean("emulated");
        region = data.optString("region", null);
    }

    /**
     * Gets the platform ID that this run was played on
     *
     * @return the platform ID
     *
     * @see Platform
     * @see Spedran#getPlatform(String)
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Gets whether the run was played on an emulator.
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
     * @see Region
     * @see Spedran#getRegion(String)
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
