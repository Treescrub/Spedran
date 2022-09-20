package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Objects;

public class Region extends Resource {
    private String id;
    private String name;

    public Region(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Region(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return id.equals(region.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
