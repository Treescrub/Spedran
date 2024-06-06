package com.github.treescrub.spedran.category;

import com.github.treescrub.spedran.JSONLoader;
import com.github.treescrub.spedran.data.category.CategoryPlayers;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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