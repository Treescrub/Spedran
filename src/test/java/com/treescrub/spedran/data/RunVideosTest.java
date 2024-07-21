package com.treescrub.spedran.data;

import com.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RunVideosTest {

    @Test
    void getText() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runvideos");
        RunVideos runVideos = new RunVideos(json);

        assertFalse(runVideos.getText().isPresent());
    }

    @Test
    void getLinks() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runvideos");
        RunVideos runVideos = new RunVideos(json);

        assertFalse(runVideos.getLinks().isEmpty());
        assertThrows(UnsupportedOperationException.class, () -> runVideos.getLinks().clear());
    }
}