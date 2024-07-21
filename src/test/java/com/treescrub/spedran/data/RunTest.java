package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RunTest {

    @Test
    void getWeblink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertEquals("https://www.speedrun.com/l4d2/run/yvrk7voz", run.getWeblink());
    }

    @Test
    void getGame() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertEquals("9dowpe1p", run.getGame());
    }

    @Test
    void getLevel() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertTrue(run.getLevel().isPresent());
        assertEquals("5d77z5dy", run.getLevel().get());
    }

    @Test
    void getCategory() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertEquals("824m5e25", run.getCategory());
    }

    @Test
    void getVideos() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertTrue(run.getVideos().isPresent());
    }

    @Test
    void getComment() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertTrue(run.getComment().isPresent());
        assertFalse(run.getComment().get().isEmpty());
    }

    @Test
    void getStatus() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertNotNull(run.getStatus());
    }

    @Test
    void getPlayers() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertFalse(run.getPlayers().isEmpty());
        assertThrows(UnsupportedOperationException.class, () -> run.getPlayers().clear());
    }

    @Test
    void getDateRan() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);
        LocalDate runDate = LocalDate.parse("2022-07-21");

        assertTrue(run.getDateRan().isPresent());
        assertEquals(runDate, run.getDateRan().get());
    }

    @Test
    void getSubmitTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);
        Instant submitTime = Instant.parse("2022-07-21T00:56:22Z");

        assertTrue(run.getSubmitTime().isPresent());
        assertEquals(submitTime, run.getSubmitTime().get());
    }

    @Test
    void getRunTimes() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertNotNull(run.getRunTimes());
        assertThrows(UnsupportedOperationException.class, () -> run.getVariableValues().clear());
    }

    @Test
    void getSystem() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertNotNull(run.getSystem());
    }

    @Test
    void getSplits() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertFalse(run.getSplits().isPresent());
    }

    @Test
    void getVariableValues() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/run");
        Run run = new Run(json);

        assertTrue(run.getVariableValues().containsKey("wl30jvl1"));
        assertEquals("klrjykmq", run.getVariableValues().get("wl30jvl1"));
    }
}