package com.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.time.Duration;
import java.util.Optional;

/**
 * Contains info of all times set for a run.
 * <br><br>
 * This class is immutable and thread-safe.
 *
 * @see Run
 * @see Run#getRunTimes()
 */
public class RunTimes {
    private final Duration primaryTime;
    private final Duration realTime;
    private final Duration realNoLoadsTime;
    private final Duration ingameTime;

    RunTimes(JSONObject data) {
        primaryTime = Duration.parse(data.getString("primary"));
        realTime = !data.isNull("realtime") ? Duration.parse(data.getString("realtime")) : null;
        realNoLoadsTime = !data.isNull("realtime_noloads") ? Duration.parse(data.getString("realtime_noloads")) : null;
        ingameTime = !data.isNull("ingame") ? Duration.parse(data.getString("ingame")) : null;
    }

    /**
     * Gets the primary or default time of this run.
     * The timing type is determined by the {@link GameRuleset}
     *
     * @return a {@link Duration} with the primary time
     */
    public Duration getPrimaryTime() {
        return primaryTime;
    }

    /**
     * Gets the real time of this run.
     *
     * @return a {@link Optional} with a {@link Duration} with the real time
     */
    public Optional<Duration> getRealTime() {
        return Optional.ofNullable(realTime);
    }

    /**
     * Gets the real with loads removed time of this run.
     *
     * @return a {@link Optional} with a {@link Duration} with the real with loads removed time
     */
    public Optional<Duration> getRealNoLoadsTime() {
        return Optional.ofNullable(realNoLoadsTime);
    }

    /**
     * Gets the in-game time of this run.
     *
     * @return a {@link Optional} with a {@link Duration} with the in-game time
     */
    public Optional<Duration> getIngameTime() {
        return Optional.ofNullable(ingameTime);
    }

    @Override
    public String toString() {
        return "RunTimes{" +
                "primaryTime=" + primaryTime +
                ", realTime=" + realTime +
                ", realNoLoadsTime=" + realNoLoadsTime +
                ", ingameTime=" + ingameTime +
                '}';
    }
}
