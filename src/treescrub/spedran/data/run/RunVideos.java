package treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;
import treescrub.spedran.data.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RunVideos {
    private String text;
    private List<Link> links;

    public RunVideos(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        text = data.isNull("text") ? null : data.getString("text");
        links = new ArrayList<>();
        for (int i = 0; i < data.getJSONArray("links").length(); i++) {
            links.add(new Link(data.getJSONArray("links").getJSONObject(i)));
        }
    }

    public Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    public List<Link> getLinks() {
        return links;
    }
}
