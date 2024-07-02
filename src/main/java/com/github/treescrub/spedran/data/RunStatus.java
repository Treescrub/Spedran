package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.Spedran;
import kong.unirest.json.JSONObject;

import java.time.Instant;
import java.util.Optional;

/**
 * The verification status of a {@link Run} on SRC.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class RunStatus {
    private final SubmissionStatus submissionStatus;
    private final String examiner;
    private final Instant verifyDate;
    private final String reason;

    RunStatus(JSONObject data) {
        submissionStatus = SubmissionStatus.valueOf(data.getString("status").toUpperCase());
        examiner = data.optString("examiner", null);
        if(!data.isNull("verify-date")) {
            verifyDate = Instant.parse(data.getString("verify-date"));
        } else {
            verifyDate = null;
        }
        reason = data.optString("reason", null);
    }

    /**
     * Gets the submission status type.
     *
     * @return a {@code SubmissionStatus}
     */
    public SubmissionStatus getStatus() {
        return submissionStatus;
    }

    /**
     * Gets the ID of the verifier.
     * <br><br>
     * Only exists if status is {@link SubmissionStatus#VERIFIED} or {@link SubmissionStatus#REJECTED}.
     *
     * @return an {@link Optional} with the ID of the verifier
     *
     * @see User
     * @see Spedran#getUser(String)
     */
    public Optional<String> getExaminer() {
        return Optional.ofNullable(examiner);
    }

    /**
     * Gets the time that the run was verified.
     * <br><br>
     * Only exists if the status is {@link SubmissionStatus#VERIFIED}.
     *
     * @return an {@link Optional} with the {@link Instant} of verification
     */
    public Optional<Instant> getVerifyDate() {
        return Optional.ofNullable(verifyDate);
    }

    /**
     * Gets the verifier supplied reason for rejection.
     * <br><br>
     * Only exists if the status is {@link SubmissionStatus#REJECTED}.
     *
     * @return the reason for rejection
     */
    @SuppressWarnings("unused")
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
