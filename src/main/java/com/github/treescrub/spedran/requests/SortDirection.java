package com.github.treescrub.spedran.requests;

public enum SortDirection {
    ASCENDING,
    DESCENDING;

    public String toParameter() {
        if(this == ASCENDING) {
            return "asc";
        } else {
            return "desc";
        }
    }
}
