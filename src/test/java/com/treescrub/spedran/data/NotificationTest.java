package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    @Test
    void getCreationTime() {
        JSONObject json = JSONLoader.getJsonTestFile("notifications/run");
        Notification notification = new Notification(json);

        assertEquals(Instant.parse("2024-07-24T15:32:28Z"), notification.getCreationTime());
    }

    @Test
    void getStatus() {
        JSONObject readJson = JSONLoader.getJsonTestFile("notifications/run");
        JSONObject unreadJson = JSONLoader.getJsonTestFile("notifications/post");
        Notification readNotification = new Notification(readJson);
        Notification unreadNotification = new Notification(unreadJson);

        assertEquals(NotificationStatus.READ, readNotification.getStatus());
        assertEquals(NotificationStatus.UNREAD, unreadNotification.getStatus());
    }

    @Test
    void getNotificationText() {
        JSONObject json = JSONLoader.getJsonTestFile("notifications/run");
        Notification notification = new Notification(json);

        assertEquals("A new run is waiting for verification in Left 4 Dead 2 Dead Center Solo - Any Difficulty", notification.getNotificationText());
    }

    @Test
    void getItemLink() {
        JSONObject json = JSONLoader.getJsonTestFile("notifications/post");
        Notification notification = new Notification(json);

        assertTrue(notification.getItemLink().getRelation().isPresent());
        assertEquals("post", notification.getItemLink().getRelation().get());
        assertEquals("https://www.speedrun.com/l4d2_cc/runs/y8p9n7wz", notification.getItemLink().getURI());
    }
}