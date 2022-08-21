package treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class Level extends IdentifiableResource {
    private String name;
    private URL weblink;
    private String rules;

    Level(String id) {
        super(id);
    }

    @Override
    protected void populate(JSONObject data) {
        name = data.getString("name");
        try {
            weblink = new URL(data.getString("weblink"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        rules = data.getString("rules");
    }
}
