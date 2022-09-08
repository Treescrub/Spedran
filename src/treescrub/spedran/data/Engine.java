package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

public class Engine extends Resource {
    private String id;
    private String name;

    public Engine(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
    }

    public Engine(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
