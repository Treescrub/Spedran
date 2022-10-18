package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    private static JSONObject getJsonBase() {
        return new JSONObject("{\"id\":\"id\",\"name\":\"name\",\"weblink\":\"weblink\"}");
    }

    @Test
    void getWeblink() {
        JSONObject json = getJsonBase();
        Level level = new Level(json);

        assertEquals("weblink", level.getWeblink());
    }

    @Test
    void getRulesEmpty() {
        JSONObject json = getJsonBase().putOnce("rules", null);
        Level level = new Level(json);

        assertTrue(level.getRules().isEmpty());
    }

    @Test
    void getRulesPresent() {
        JSONObject json = getJsonBase().put("rules", "rules");
        Level level = new Level(json);

        assertTrue(level.getRules().isPresent());
        assertEquals("rules", level.getRules().get());
    }
}