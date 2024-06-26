package com.github.treescrub.spedran.data.run;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class RunTimesTest {

    @Test
    void getPrimaryTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runtimes");
        RunTimes runTimes = new RunTimes(json);
        Duration time = Duration.parse("PT7M31S");

        assertEquals(time, runTimes.getPrimaryTime());
    }

    @Test
    void getRealTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runtimes");
        RunTimes runTimes = new RunTimes(json);
        Duration time = Duration.parse("PT7M31S");

        assertTrue(runTimes.getRealTime().isPresent());
        assertEquals(time, runTimes.getRealTime().get());
    }

    @Test
    void getRealNoLoadsTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runtimes");
        RunTimes runTimes = new RunTimes(json);

        assertFalse(runTimes.getRealNoLoadsTime().isPresent());
    }

    @Test
    void getIngameTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runtimes");
        RunTimes runTimes = new RunTimes(json);

        assertFalse(runTimes.getIngameTime().isPresent());
    }
}