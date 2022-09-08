package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.Map;

public class Series {
    private String id;
    private Names names;
    private String abbreviation;
    private String weblink;
    private String discord;
    private Map<String, String> moderators;
    private String created;

    public Series(JSONObject data) {
        id = data.getString("id");
    }
}
