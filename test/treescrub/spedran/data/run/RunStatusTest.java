package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;
import treescrub.spedran.data.JSONLoader;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

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