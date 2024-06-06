package com.github.treescrub.spedran.game;

import com.github.treescrub.spedran.JSONLoader;
import com.github.treescrub.spedran.data.game.Game;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getNames() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertNotNull(game.getNames());
    }

    @Test
    void getBoostsReceived() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertEquals(10, game.getBoostsReceived());
    }

    @Test
    void getDistinctBoosters() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertEquals(4, game.getDistinctBoosters());
    }

    @Test
    void getAbbreviation() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertEquals("l4d2", game.getAbbreviation());
    }

    @Test
    void getWebLink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertEquals("https://www.speedrun.com/l4d2", game.getWebLink());
    }

    @Test
    void getDiscordLink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertTrue(game.getDiscordLink().isPresent());
        assertEquals("https://discord.gg/JAUCEJmm2H", game.getDiscordLink().get());
    }

    @Test
    void getReleaseDate() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);
        LocalDate expectedDate = LocalDate.parse("2009-11-17");

        assertEquals(expectedDate, game.getReleaseDate());
    }

    @Test
    void getRuleset() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertNotNull(game.getRuleset());
    }

    @Test
    void getGametypes() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertTrue(game.getGametypes().isEmpty());
    }

    @Test
    void getPlatforms() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertFalse(game.getPlatforms().isEmpty());
    }

    @Test
    void getRegions() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertTrue(game.getRegions().isEmpty());
    }

    @Test
    void getGenres() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertFalse(game.getGenres().isEmpty());
    }

    @Test
    void getEngines() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertFalse(game.getEngines().isEmpty());
    }

    @Test
    void getDevelopers() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertFalse(game.getDevelopers().isEmpty());
    }

    @Test
    void getPublishers() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertFalse(game.getPublishers().isEmpty());
    }

    @Test
    void getModerators() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertFalse(game.getModerators().isEmpty());
        assertTrue(game.getModerators().containsKey("qjoq74l8"));
        assertEquals("moderator", game.getModerators().get("qjoq74l8"));
    }

    @Test
    void getCreationTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/game/game");
        Game game = new Game(json);

        assertFalse(game.getCreationTime().isPresent());
    }
}