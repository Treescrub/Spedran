package com.treescrub.spedran.data;

import kong.unirest.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Has information about all video links in the run.
 * <br>
 * Includes the main video section and videos linked in the description.
 * <br>
 * If the main video section contains more than just a video link, {@link RunVideos#text} is set.
 * <br><br>
 * This class is immutable and thread-safe.
 */
public class RunVideos {
    private final String text;
    private final List<Link> links;

    RunVideos(JSONObject data) {
        text = data.isNull("text") ? null : data.getString("text");
        List<Link> tempLinks = new ArrayList<>();
        if(data.has("links")) {
            for (int i = 0; i < data.getJSONArray("links").length(); i++) {
                tempLinks.add(new Link(data.getJSONArray("links").getJSONObject(i)));
            }
        }
        links = Collections.unmodifiableList(tempLinks);
    }

    /**
     * Gets the full text of the main video section if it contains more than just a video link.
     *
     * @return an {@link Optional} with the full text
     */
    public Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    /**
     * Gets the video links mentioned in the run.
     * <br>
     * If the main video section contains a valid video link, it will be at the end of the returned list.
     *
     * @return an unmodifiable {@code List} of {@link Link}s to videos
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
