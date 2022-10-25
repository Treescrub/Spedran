package treescrub.spedran.data.category;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;
import treescrub.spedran.data.JSONLoader;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void getWeblink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/category/category");
        Category category = new Category(json);

        assertNotNull(category.getWeblink());
        assertEquals("https://www.speedrun.com/l4d2#Main_Campaigns_Solo", category.getWeblink());
    }

    @Test
    void isPerLevel() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/category/category");
        Category category = new Category(json);

        assertFalse(category.isPerLevel());
    }

    @Test
    void getRules() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/category/category");
        Category category = new Category(json);

        assertNotNull(category.getRules());
        assertFalse(category.getRules().isEmpty());
    }

    @Test
    void getPlayers() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/category/category");
        Category category = new Category(json);

        assertNotNull(category.getPlayers());
    }

    @Test
    void isMiscellaneous() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/category/category");
        Category category = new Category(json);

        assertFalse(category.isMiscellaneous());
    }
}