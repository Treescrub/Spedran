package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void getName() {
        JSONObject json = JSONLoader.getJsonTestFile("guest");
        Guest guest = new Guest(json);

        assertEquals("test", guest.getName());
    }

    @Test
    void testEquals() {
        JSONObject json = JSONLoader.getJsonTestFile("guest");
        Guest guest = new Guest(json);
        Guest sameGuest = new Guest(json);

        assertEquals(guest, sameGuest);
    }

    @Test
    void testHashCode() {
        JSONObject json = JSONLoader.getJsonTestFile("guest");
        Guest guest = new Guest(json);
        Guest sameGuest = new Guest(json);

        assertEquals(guest.hashCode(), sameGuest.hashCode());
    }
}