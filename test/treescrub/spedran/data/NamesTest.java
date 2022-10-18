package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NamesTest {

    @Test
    void getInternationalName() {
        JSONObject json = JSONLoader.getJsonTestFile("names/international_only");
        Names names = new Names(json);

        assertEquals("international", names.getInternationalName());
    }

    @Test
    void getJapaneseNamePresent() {
        JSONObject json = JSONLoader.getJsonTestFile("names/japanese");
        Names names = new Names(json);

        assertTrue(names.getJapaneseName().isPresent());
        assertEquals("japanese", names.getJapaneseName().get());
    }

    @Test
    void getJapaneseNameMissing() {
        JSONObject json = JSONLoader.getJsonTestFile("names/international_only");
        Names names = new Names(json);

        assertTrue(names.getJapaneseName().isEmpty());
    }

    @Test
    void getTwitchNamePresent() {
        JSONObject json = JSONLoader.getJsonTestFile("names/twitch");
        Names names = new Names(json);

        assertTrue(names.getTwitchName().isPresent());
        assertEquals("twitch", names.getTwitchName().get());
    }

    @Test
    void getTwitchNameMissing() {
        JSONObject json = JSONLoader.getJsonTestFile("names/international_only");
        Names names = new Names(json);

        assertTrue(names.getTwitchName().isEmpty());
    }
}