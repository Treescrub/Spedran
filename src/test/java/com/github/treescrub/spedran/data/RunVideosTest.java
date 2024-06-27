package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
    }
}