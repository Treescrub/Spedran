package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

public class Developer extends Resource {
    private String id;
    private String name;

    public Developer(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
    }

    public Developer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
