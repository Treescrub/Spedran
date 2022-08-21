package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

public abstract class IdentifiableResource extends Resource {
    protected String id;
    private boolean isEmpty;

    IdentifiableResource(String id) {
        this(id, true);
    }

    IdentifiableResource(String id, boolean isEmpty) {
        this.id = id;
        this.isEmpty = isEmpty;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isPopulated() {
        return !isEmpty;
    }

    protected abstract void populate(JSONObject data);
}
