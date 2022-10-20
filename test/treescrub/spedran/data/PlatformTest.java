package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatformTest {

    @Test
    void getReleaseYear() {
        JSONObject json = JSONLoader.getJsonTestFile("Platform/released_2005");
        Platform platform = new Platform(json);

        assertEquals(2005, platform.getReleaseYear());
    }
}