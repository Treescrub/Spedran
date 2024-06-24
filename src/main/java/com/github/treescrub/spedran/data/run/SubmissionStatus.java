package com.github.treescrub.spedran.data.run;

/**
 * The submission status type for a run.
 *
 * @see Run
 * @see Run#getStatus()
 */
public enum SubmissionStatus {
    /**
     * The run is currently in the verification queue.
     */
    NEW,
    /**
     * The run was rejected by a verifier.
     */
    REJECTED,
    /**
     * The run was verified by a verifier.
     */
    VERIFIED,
    ;

    public String toAPIName() {
        return this.name().toLowerCase();
    }
}
