package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameColorTest {

    @Test
    void getLight() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/namecolor");
        NameColor nameColor = new NameColor(json);

        assertEquals(Color.decode("#000000"), nameColor.getLight());
    }

    @Test
    void getDark() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/namecolor");
        NameColor nameColor = new NameColor(json);

        assertEquals(Color.decode("#FFFFFF"), nameColor.getDark());
    }
}