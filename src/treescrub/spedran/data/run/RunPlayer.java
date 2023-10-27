package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Link;

/**
 * Has information about a specific runner.
 * Only makes sense in the context of a run.
 */
public class RunPlayer extends Link {
    private String id;
    private boolean isGuest;

    public RunPlayer(JSONObject data) {
        super(data);
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        if (!data.isNull("id")) {
            id = data.getString("id");
            isGuest = false;
        }
        if (!data.isNull("name")) {
            id = data.getString("name");
            isGuest = true;
        }
    }

    public boolean isGuest() {
        return isGuest;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RunPlayer[" + id + "]";
    }
}
