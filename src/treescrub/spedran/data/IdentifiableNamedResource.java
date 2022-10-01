package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

public class IdentifiableNamedResource extends IdentifiableResource {
    private String name;

    public IdentifiableNamedResource(JSONObject data) {
        super(data);
        name = data.getString("name");
    }

    public String getName() {
        return name;
    }
}
