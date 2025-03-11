package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
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

    @Test
    void getGame() {
        JSONObject json = JSONLoader.getJsonTestFile("embedding/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertTrue(leaderboard.getGame().isEmbedded());
    }

    @Test
    void getCategory() {
        JSONObject json = JSONLoader.getJsonTestFile("embedding/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertTrue(leaderboard.getCategory().isEmbedded());
    }

    @Test
    void getLevel() {
        JSONObject json = JSONLoader.getJsonTestFile("embedding/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertTrue(leaderboard.getLevel().isPresent());
        assertTrue(leaderboard.getLevel().get().isEmbedded());
    }

    @Test
    void getPlatforms() {
        JSONObject json = JSONLoader.getJsonTestFile("embedding/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertTrue(leaderboard.getPlatforms().isPresent());
        assertFalse(leaderboard.getPlatforms().get().isEmpty());
    }

    @Test
    void getRegions() {
        JSONObject json = JSONLoader.getJsonTestFile("embedding/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertTrue(leaderboard.getRegions().isPresent());
        assertFalse(leaderboard.getRegions().get().isEmpty());
    }

    @Test
    void getVariables() {
        JSONObject json = JSONLoader.getJsonTestFile("embedding/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertTrue(leaderboard.getVariables().isPresent());
        assertFalse(leaderboard.getVariables().get().isEmpty());
    }

    @Test
    void getPlayers() {
        JSONObject json = JSONLoader.getJsonTestFile("embedding/leaderboard");
        Leaderboard leaderboard = new Leaderboard(json);

        assertTrue(leaderboard.getPlayers().isPresent());
        assertFalse(leaderboard.getPlayers().get().isEmpty());
    }
}
