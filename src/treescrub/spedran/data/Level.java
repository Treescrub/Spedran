package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class Level extends Resource {
    private String name;
    private URL weblink;
    private String rules;

    public Level(JSONObject data) {
        name = data.getString("name");
        try {
            weblink = new URL(data.getString("weblink"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        rules = data.getString("rules");
    }
}
