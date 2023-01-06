package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Link;

public class RunPlayer extends Link {
    private String id;

    public RunPlayer(JSONObject data) {
        super(data);
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        if (!data.isNull("id"))
            id = data.getString("id");
        if (!data.isNull("name"))
            id = data.getString("name");
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RunPlayer[" + id + "]";
    }
}
