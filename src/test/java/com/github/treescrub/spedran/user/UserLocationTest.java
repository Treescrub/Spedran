package com.github.treescrub.spedran.user;

import com.github.treescrub.spedran.JSONLoader;
import com.github.treescrub.spedran.data.user.UserLocation;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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