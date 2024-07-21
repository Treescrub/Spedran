package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameStyleTest {

    @Test
    void getStyle() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/namestyle");
        NameStyle nameStyle = new NameStyle(json);

        assertEquals(NameStyle.Style.GRADIENT, nameStyle.getStyle());
    }

    @Test
    void getColor() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/namestyle");
        NameStyle nameStyle = new NameStyle(json);

        assertFalse(nameStyle.getColor().isPresent());
    }

    @Test
    void getStartColor() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/namestyle");
        NameStyle nameStyle = new NameStyle(json);

        assertTrue(nameStyle.getStartColor().isPresent());
    }

    @Test
    void getEndColor() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/namestyle");
        NameStyle nameStyle = new NameStyle(json);

        assertTrue(nameStyle.getEndColor().isPresent());
    }
}