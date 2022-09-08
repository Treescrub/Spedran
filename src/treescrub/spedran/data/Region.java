package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import java.util.Optional;

public class Region extends Resource {
    private String id;
    private String name;

    public Region(JSONObject data) {
        id = data.getString("id");
        name = data.getString("name");
    }

    public String getId() {
        return id;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
