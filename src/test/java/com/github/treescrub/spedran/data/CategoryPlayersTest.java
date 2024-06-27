package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryPlayersTest {

    @Test
    void isExact() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/category/categoryplayers");
        CategoryPlayers players = new CategoryPlayers(json);

        assertTrue(players.isExact());
    }

    @Test
    void getPlayers() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/category/categoryplayers");
        CategoryPlayers players = new CategoryPlayers(json);

        assertEquals(1, players.getPlayers());
    }
}