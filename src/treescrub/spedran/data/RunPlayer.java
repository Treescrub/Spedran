package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

public class RunPlayer extends Link {
    private String id;

    public RunPlayer(JSONObject data) {
        super(data);
        if (!data.isNull("id"))
            id = data.getString("id");
        if (!data.isNull("name"))
            id = data.getString("name");
    }

    public String getId() {
        return id;
    }
}
