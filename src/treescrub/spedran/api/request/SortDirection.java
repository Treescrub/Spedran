package treescrub.spedran.api.request;

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
