package treescrub.spedran.data.user;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;
import treescrub.spedran.data.JSONLoader;

import static org.junit.jupiter.api.Assertions.*;

class LocationInfoTest {

    @Test
    void getCode() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/locationinfo");
        LocationInfo locationInfo = new LocationInfo(json);

        assertEquals("gb/sct", locationInfo.getCode());
    }

    @Test
    void getNames() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/locationinfo");
        LocationInfo locationInfo = new LocationInfo(json);

        assertNotNull(locationInfo.getNames());
    }

    @Test
    void testEquals() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/user/locationinfo");
        LocationInfo locationInfo = new LocationInfo(json);

        assertEquals(new LocationInfo(json), locationInfo);
    }
}