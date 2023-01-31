package treescrub.spedran.api;

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
