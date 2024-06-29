package com.github.treescrub.spedran.requests;

/**
 * The sorting direction for requests of collections of resources.
 */
@SuppressWarnings("unused")
public enum SortDirection {
    /**
     * The list will be sorted from the lowest values at the start of the list to the highest at the end of the list.
     * <br><br>
     * For dates/times, this will sort from oldest to newest.
     */
    ASCENDING,
    /**
     * The list will be sorted from the highest values at the start of the list to the lowest at the end of the list.
     * <br><br>
     * For dates/times, this will sort from newest to oldest.
     */
    DESCENDING;

    /**
     * Gets the SRC API query parameter string.
     *
     * @return a {@code String} with the query parameter value for use with the SRC API
     */
    public String toParameter() {
        if(this == ASCENDING) {
            return "asc";
        } else {
            return "desc";
        }
    }
}
