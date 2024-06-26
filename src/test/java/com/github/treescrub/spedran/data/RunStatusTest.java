package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RunStatusTest {

    @Test
    void getStatus() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runstatus/verified");
        RunStatus status = new RunStatus(json);

        assertEquals(SubmissionStatus.VERIFIED, status.getStatus());
    }

    @Test
    void getExaminer() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runstatus/verified");
        RunStatus status = new RunStatus(json);

        assertTrue(status.getExaminer().isPresent());
        assertEquals("zxzevrrx", status.getExaminer().get());
    }

    @Test
    void getVerifyDate() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/run/runstatus/verified");
        RunStatus status = new RunStatus(json);
        Instant verifyDate = Instant.parse("2022-07-27T18:40:36Z");

        assertTrue(status.getVerifyDate().isPresent());
        assertEquals(verifyDate, status.getVerifyDate().get());
    }
}