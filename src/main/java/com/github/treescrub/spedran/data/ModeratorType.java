package com.github.treescrub.spedran.data;

public enum ModeratorType {
    SUPER_MODERATOR,
    MODERATOR;

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
