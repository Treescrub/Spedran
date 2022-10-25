package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;
import treescrub.spedran.data.JSONLoader;

import static org.junit.jupiter.api.Assertions.*;

class RunPlayerTest {

    @Test
    void getId() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runplayer");
        RunPlayer runPlayer = new RunPlayer(json);

        assertEquals("xz749vej", runPlayer.getId());
    }
}