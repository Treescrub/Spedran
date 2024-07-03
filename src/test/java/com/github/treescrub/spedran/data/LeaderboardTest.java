package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {
    @Test
    void getValues() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/leaderboard/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertTrue(leaderboard.getValues().isEmpty());
        assertThrows(UnsupportedOperationException.class, () -> leaderboard.getValues().clear());
    }

    @Test
    void getRuns() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/leaderboard/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertFalse(leaderboard.getRuns().isEmpty());
        assertThrows(UnsupportedOperationException.class, () -> leaderboard.getRuns().clear());
    }
}
