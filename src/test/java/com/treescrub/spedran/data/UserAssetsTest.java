package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAssetsTest {

    @Test
    void getIcon() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/userassets");
        UserAssets userAssets = new UserAssets(json);

        assertTrue(userAssets.getIcon().isEmpty());
    }

    @Test
    void getSupporterIcon() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/userassets");
        UserAssets userAssets = new UserAssets(json);

        assertTrue(userAssets.getSupporterIcon().isEmpty());
    }

    @Test
    void getAvatar() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/userassets");
        UserAssets userAssets = new UserAssets(json);

        assertTrue(userAssets.getAvatar().isPresent());
        assertEquals("https://www.speedrun.com/static/user/zx721w08/image?v=0705d37", userAssets.getAvatar().get().getURI());
    }
}