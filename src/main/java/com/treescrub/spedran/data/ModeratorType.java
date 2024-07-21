package com.treescrub.spedran.data;

/**
 * The type of moderator.
 * <br><br>
 * <b>Verifiers are returned as super moderators from the SRC API!</b>
 */
public enum ModeratorType {
    /**
     * The highest privileged moderator type.
     * Super moderators are just like moderators, but can change the moderator types of moderators and verifiers.
     * <br><br>
     * <b>The SRC API will return super moderator if the user is a verifier!</b>
     */
    SUPER_MODERATOR,
    /**
     * A basic moderator. Moderators have access to everything except modifying roles of users and other moderators.
     */
    MODERATOR;

    /**
     * Gets the enum that corresponds to the given SRC API name for the moderator type.
     *
     * @param apiName the name as returned from the SRC API
     * @return the corresponding enum
     */
    static ModeratorType fromAPI(String apiName) {
        switch(apiName) {
            case "moderator":
                return MODERATOR;
            case "super-moderator":
                return SUPER_MODERATOR;
        }

        throw new IllegalArgumentException("Unknown moderator type: '" + apiName + "'");
    }
}
