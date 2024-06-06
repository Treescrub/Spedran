package com.github.treescrub.spedran;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;
import com.github.treescrub.spedran.data.Series;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    void getNames() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/series");
        Series series = new Series(json);

        assertNotNull(series.getNames());
    }

    @Test
    void getAbbreviation() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/series");
        Series series = new Series(json);

        assertEquals("left_4_dead", series.getAbbreviation());
    }

    @Test
    void getWeblink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/series");
        Series series = new Series(json);

        assertEquals("https://www.speedrun.com/left_4_dead", series.getWeblink());
    }

    @Test
    void getDiscord() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/series");
        Series series = new Series(json);

        assertNotNull(series.getDiscord());
        assertTrue(series.getDiscord().isPresent());
        assertEquals("https://discordapp.com/invite/ugEWwa5", series.getDiscord().get());
    }

    @Test
    void getModerators() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/series");
        Series series = new Series(json);

        assertNotNull(series.getModerators());
        assertTrue(series.getModerators().containsKey("68wk1gl8"));
        assertEquals("super-moderator", series.getModerators().get("68wk1gl8"));
    }

    @Test
    void getCreationTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/series");
        Series series = new Series(json);
        Instant creationTime = Instant.parse("2014-12-19T20:28:43Z");

        assertNotNull(series.getCreationTime());
        assertTrue(series.getCreationTime().isPresent());
        assertEquals(creationTime, series.getCreationTime().get());
    }
}