package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.util.Optional;

/**
 * Holds information about the current run status.
 */
public class RunStatus {
    private SubmissionStatus submissionStatus;
    private String examiner;
    private Instant verifyDate;
    private String reason;

    public RunStatus(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        submissionStatus = SubmissionStatus.valueOf(data.getString("status").toUpperCase());
        examiner = data.optString("examiner", null);
        if(!data.isNull("verify-date")) {
            verifyDate = Instant.parse(data.getString("verify-date"));
        }
        reason = data.optString("reason", null);
    }

    /**
     * Returns the status.
     *
     * @return a {@link SubmissionStatus}
     */
    public SubmissionStatus getStatus() {
        return submissionStatus;
    }

    /**
     * Returns the ID of the verifier.
     * Only exists if status is {@link SubmissionStatus#VERIFIED} or {@link SubmissionStatus#REJECTED}.
     *
     * @return an {@link Optional} with the ID of the verifier
     * @see treescrub.spedran.api.Spedran#getUser(String)
     */
    public Optional<String> getExaminer() {
        return Optional.ofNullable(examiner);
    }

    /**
     * Returns the time of verification.
     * Only exists if status is {@link SubmissionStatus#VERIFIED}.
     *
     * @return an {@link Optional} with the {@link Instant} of verification
     */
    public Optional<Instant> getVerifyDate() {
        return Optional.ofNullable(verifyDate);
    }

    /**
     *
     *
     * @return
     */
    public Optional<String> getReason() {
        return Optional.ofNullable(reason);
    }

    @Override
    public String toString() {
        return "RunStatus{" +
                "submissionStatus=" + submissionStatus +
                ", examiner='" + examiner + '\'' +
                ", verifyDate=" + verifyDate +
                '}';
    }
}
