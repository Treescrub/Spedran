package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.util.Optional;

enum SubmissionStatus {
    NEW,
    REJECTED,
    VERIFIED,
}

public class RunStatus {
    private SubmissionStatus submissionStatus;
    private String examiner;
    private Instant verifyDate;

    public RunStatus(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        submissionStatus = SubmissionStatus.valueOf(data.getString("status").toUpperCase());
        examiner = data.optString("examiner", null);
        if (!data.isNull("verify-date"))
            verifyDate = Instant.parse(data.getString("verify-date"));
    }

    public SubmissionStatus getStatus() {
        return submissionStatus;
    }

    public Optional<String> getExaminer() {
        return Optional.ofNullable(examiner);
    }

    public Optional<Instant> getVerifyDate() {
        return Optional.ofNullable(verifyDate);
    }
}
