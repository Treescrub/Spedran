package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.time.Duration;

public class RunTimes {
    private Duration primaryTime;
    private Duration realTime;
    private Duration realNoLoadsTime;
    private Duration ingameTime;

    public RunTimes(JSONObject data) {
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

    public Duration getRealTime() {
        return realTime;
    }

    public Duration getRealNoLoadsTime() {
        return realNoLoadsTime;
    }

    public Duration getIngameTime() {
        return ingameTime;
    }
}
