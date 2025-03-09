package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void getId() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runplayer");

        Player player = new Player(json);

        assertTrue(player.isUser());
        assertTrue(player.getUser().isPresent());
        assertEquals("xz749vej", player.getUser().get().getId());
    }
}