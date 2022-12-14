package treescrub.spedran.data.category;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;
import treescrub.spedran.data.JSONLoader;

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