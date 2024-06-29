package com.github.treescrub.spedran.requests;

/**
 * An exception that signifies a request builder being in an invalid state.
 */
public class InvalidBuilderStateException extends Exception {
    @SuppressWarnings("unused")
    public InvalidBuilderStateException(String message) {
        super(message);
    }
}
