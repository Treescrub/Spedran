package com.github.treescrub.spedran.data.run;

import kong.unirest.json.JSONObject;
import com.github.treescrub.spedran.data.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Links and primary video text if anything other than single link found.
 */
public class RunVideos {
    private String text;
    private List<Link> links;

    public RunVideos(JSONObject data) {
        parseFromJson(data);
    }

    private void parseFromJson(JSONObject data) {
        text = data.isNull("text") ? null : data.getString("text");
        links = new ArrayList<>();
        if(data.has("links")) {
            for (int i = 0; i < data.getJSONArray("links").length(); i++) {
                links.add(new Link(data.getJSONArray("links").getJSONObject(i)));
            }
        }
    }

    /**
     *
     * @return
     */
    public Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    /**
     *
     * @return
     */
    public List<Link> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "RunVideos{" +
                "text='" + text + '\'' +
                ", links=" + links +
                '}';
    }
}
