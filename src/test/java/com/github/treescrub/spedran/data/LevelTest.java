package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LevelTest {
    @Test
    void getWeblink() {
        JSONObject json = JSONLoader.getJsonTestFile("Level/weblink_only");
        Level level = new Level(json);

        assertEquals("weblink", level.getWeblink());
    }

    @Test
    void getRulesEmpty() {
        JSONObject json = JSONLoader.getJsonTestFile("Level/empty_rules");
        Level level = new Level(json);

        assertTrue(level.getRules().isEmpty());
    }

    @Test
    void getRulesPresent() {
        JSONObject json = JSONLoader.getJsonTestFile("Level/rules");
        Level level = new Level(json);

        assertTrue(level.getRules().isPresent());
        assertEquals("rules", level.getRules().get());
    }
}