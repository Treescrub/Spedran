package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlatformTest {

    @Test
    void getReleaseYear() {
        JSONObject json = JSONLoader.getJsonTestFile("Platform/released_2005");
        Platform platform = new Platform(json);

        assertEquals(2005, platform.getReleaseYear());
    }
}