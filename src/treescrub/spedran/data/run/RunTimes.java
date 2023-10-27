package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;

import java.time.Duration;
import java.util.Optional;

/**
 * Has info on all run timing.
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
     *
     * @return
     */
    public Duration getPrimaryTime() {
        return primaryTime;
    }

    /**
     *
     * @return
     */
    public Optional<Duration> getRealTime() {
        return Optional.ofNullable(realTime);
    }

    /**
     *
     * @return
     */
    public Optional<Duration> getRealNoLoadsTime() {
        return Optional.ofNullable(realNoLoadsTime);
    }

    /**
     *
     * @return
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
