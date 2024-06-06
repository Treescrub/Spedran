package com.github.treescrub.spedran.user;

import com.github.treescrub.spedran.JSONLoader;
import com.github.treescrub.spedran.data.user.User;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getNames() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertNotNull(user.getNames());
    }

    @Test
    void hasSupporterAnimation() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertFalse(user.hasSupporterAnimation());
    }

    @Test
    void getPronouns() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertTrue(user.getPronouns().isPresent());
        assertEquals("He/Him", user.getPronouns().get());
    }

    @Test
    void getLink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertEquals("https://www.speedrun.com/user/matthew_1919", user.getWeblink());
    }

    @Test
    void getNameStyle() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertNotNull(user.getNameStyle());
    }

    @Test
    void getRole() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertEquals("user", user.getRole());
    }

    @Test
    void getSignupTime() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);
        Instant signupTime = Instant.parse("2021-03-09T01:31:51Z");

        assertTrue(user.getSignupTime().isPresent());
        assertEquals(signupTime, user.getSignupTime().get());
    }

    @Test
    void getLocation() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertTrue(user.getLocation().isPresent());
    }

    @Test
    void getTwitchLink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertTrue(user.getTwitchLink().isPresent());
    }

    @Test
    void getHitboxLink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertFalse(user.getHitboxLink().isPresent());
    }

    @Test
    void getYoutubeLink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertTrue(user.getYoutubeLink().isPresent());
    }

    @Test
    void getTwitterLink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertFalse(user.getTwitterLink().isPresent());
    }

    @Test
    void getSpeedrunsLiveLink() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/user");
        User user = new User(json);

        assertFalse(user.getSpeedrunsLiveLink().isPresent());
    }
}