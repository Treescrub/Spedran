package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RunSystemTest {

    @Test
    void getPlatform() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runsystem");
        RunSystem runSystem = new RunSystem(json);

        assertEquals("8gej2n93", runSystem.getPlatform());
    }

    @Test
    void isEmulated() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runsystem");
        RunSystem runSystem = new RunSystem(json);

        assertFalse(runSystem.isEmulated());
    }

    @Test
    void getRegion() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runsystem");
        RunSystem runSystem = new RunSystem(json);

        assertFalse(runSystem.getRegion().isPresent());
    }
}