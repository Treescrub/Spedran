package com.github.treescrub.spedran.data.leaderboard;

import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.data.run.Run;

/**
 *
 */
public class LeaderboardRun {
    private int place;
    private Run run;

    public LeaderboardRun(JSONObject data) {
        place = data.getInt("place");
        run = new Run(data.getJSONObject("run"));
    }

    /**
     *
     * @return
     */
    public int getPlace() {
        return place;
    }

    /**
     *
     * @return
     */
    public Run getRun() {
        return run;
    }
}
