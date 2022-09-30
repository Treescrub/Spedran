package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Objects;

public class IdentifiableResource extends Resource {
    private String id;

    public IdentifiableResource(JSONObject data) {
        id = data.getString("id");
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifiableResource that = (IdentifiableResource) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
