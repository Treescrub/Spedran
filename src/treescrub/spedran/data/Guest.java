package treescrub.spedran.data;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import java.util.Objects;

public class Guest extends Resource {
    private String name;

    public Guest(HttpResponse<JsonNode> data) {
        super(data);
    }

    public Guest(JSONObject data) {
        super(data);
    }

    @Override
    protected void parseFromJson(JSONObject data) {
        name = data.getString("name");
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return name.equals(guest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                "}";
    }
}
