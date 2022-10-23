package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;

import java.time.Duration;
import java.util.Optional;

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

    public Duration getPrimaryTime() {
        return primaryTime;
    }

    public Optional<Duration> getRealTime() {
        return Optional.ofNullable(realTime);
    }

    public Optional<Duration> getRealNoLoadsTime() {
        return Optional.ofNullable(realNoLoadsTime);
    }

    public Optional<Duration> getIngameTime() {
        return Optional.ofNullable(ingameTime);
    }
}
