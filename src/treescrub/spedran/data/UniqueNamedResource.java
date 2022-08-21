package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Optional;

public class UniqueNamedResource extends Resource {
    private String id;
    private String name;

    protected UniqueNamedResource() {}

    public UniqueNamedResource(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
    }

    public UniqueNamedResource(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
