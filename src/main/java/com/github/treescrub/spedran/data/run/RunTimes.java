package com.github.treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;

import java.time.Duration;
import java.util.Optional;

/**
 * Contains info of all times set for a run.
 *
 * @see Run
 * @see Run#getRunTimes()
 */
public class RunTimes {
    private Duration primaryTime;
    private Duration realTime;
    private Duration realNoLoadsTime;
    private Duration ingameTime;

    public RunTimes(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        primaryTime = Duration.parse(data.getString("primary"));
        if (!data.isNull("realtime"))
            realTime = Duration.parse(data.getString("realtime"));
        if (!data.isNull("realtime_noloads"))
            realNoLoadsTime = Duration.parse(data.getString("realtime_noloads"));
        if (!data.isNull("ingame"))
            ingameTime = Duration.parse(data.getString("ingame"));
    }

    /**
     * Gets the primary or default time of this run.
     * The timing type is determined by the {@link com.github.treescrub.spedran.data.game.GameRuleset}
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
