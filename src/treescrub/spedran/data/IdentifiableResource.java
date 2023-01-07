package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Objects;

public abstract class IdentifiableResource extends Resource {
    protected String id;

    public IdentifiableResource(HttpResponse<JsonNode> data) {
        super(data);
    }

    public IdentifiableResource(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
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
