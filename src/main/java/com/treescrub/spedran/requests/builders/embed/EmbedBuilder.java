package com.treescrub.spedran.requests.builders.embed;

import java.util.*;

/**
 * Builds a set of embed strings for a specific resource.
 */
public abstract class EmbedBuilder {
    private final Set<String> embedStrings;

    protected EmbedBuilder() {
        embedStrings = new HashSet<>();
    }

    protected void addEmbed(String value) {
        embedStrings.add(value);
    }

    /**
     * Gets the embed strings as a new {@code List}.
     *
     * @return a {@code List} of embed strings
     */
    public List<String> getEmbedStrings() {
        return new ArrayList<>(embedStrings);
    }
}
