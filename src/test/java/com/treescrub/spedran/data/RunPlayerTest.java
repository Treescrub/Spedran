package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RunPlayerTest {

    @Test
    void getId() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runplayer");
        RunPlayer runPlayer = new RunPlayer(json);

        assertEquals("xz749vej", runPlayer.getId());
    }
}