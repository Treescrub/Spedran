package com.github.treescrub.spedran.user;

import com.github.treescrub.spedran.JSONLoader;
import com.github.treescrub.spedran.data.user.NameColor;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameColorTest {

    @Test
    void getLight() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/namecolor");
        NameColor nameColor = new NameColor(json);

        assertEquals("#000000", nameColor.getLight());
    }

    @Test
    void getDark() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/namecolor");
        NameColor nameColor = new NameColor(json);

        assertEquals("#FFFFFF", nameColor.getDark());
    }
}