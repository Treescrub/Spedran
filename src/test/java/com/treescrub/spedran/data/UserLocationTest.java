package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserLocationTest {

    @Test
    void getCountry() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/userlocation");
        UserLocation userLocation = new UserLocation(json);

        assertNotNull(userLocation.getCountry());
    }

    @Test
    void getRegion() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/userlocation");
        UserLocation userLocation = new UserLocation(json);

        assertFalse(userLocation.getRegion().isPresent());
    }
}