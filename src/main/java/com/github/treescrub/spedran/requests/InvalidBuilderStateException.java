package com.github.treescrub.spedran.requests;

/**
 * An exception that signifies a request builder being in an invalid state.
 */
public class InvalidBuilderStateException extends Exception {
    public InvalidBuilderStateException(String message) {
        super(message);
    }
}
