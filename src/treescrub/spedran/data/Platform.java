package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Objects;

public class Platform {
    private String id;
    private String name;
    private int released;

    public Platform(HttpResponse<JsonNode> data) {
        this(data.getBody().getObject().getJSONObject("data"));
    }

    public Platform(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
        released = data.getInt("released");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return released;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return id.equals(platform.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
