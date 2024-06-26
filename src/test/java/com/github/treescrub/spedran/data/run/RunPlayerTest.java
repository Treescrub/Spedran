package com.github.treescrub.spedran.data.run;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunPlayerTest {

    @Test
    void getId() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runplayer");
        RunPlayer runPlayer = new RunPlayer(json);

        assertEquals("xz749vej", runPlayer.getId());
    }
}