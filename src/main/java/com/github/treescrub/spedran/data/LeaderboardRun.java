package com.github.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

/**
 * A run on a leaderboard. Has a place on the leaderboard and the associated run.
 */
public class LeaderboardRun extends Resource {
    private final int place;
    private final Run run;

    LeaderboardRun(JSONObject data) {
        super(data);

        place = data.getInt("place");
        run = new Run(data.getJSONObject("run"));
    }

    /**
     * Gets the ranking/place of the run.
     * Leaderboard runs that are part of the same leaderboard can have duplicate places.
     *
     * @return the placement of this run on the leaderboard
     */
    public int getPlace() {
        return place;
    }

    /**
     * Gets the associated run.
     *
     * @return the run
     */
    public Run getRun() {
        return run;
    }

    @Override
    public String toString() {
        return "LeaderboardRun{" +
                "place=" + place +
                ", run=" + run +
                '}';
    }
}