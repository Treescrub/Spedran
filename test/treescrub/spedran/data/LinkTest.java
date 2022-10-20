package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    @Test
    void getURI() {
        JSONObject json = JSONLoader.getJsonTestFile("Link/uri_only");
        Link link = new Link(json);

        assertEquals("uri", link.getURI());
    }

    @Test
    void getRelationPresent() {
        JSONObject json = new JSONObject("{\"uri\":\"uri\",\"rel\":\"rel\"}");
        Link link = new Link(json);

        assertTrue(link.getRelation().isPresent());
        assertEquals("rel", link.getRelation().get());
    }

    @Test
    void getRelationMissing() {
        JSONObject json = new JSONObject("{\"uri\":\"uri\"}");
        Link link = new Link(json);

        assertTrue(link.getRelation().isEmpty());
    }
}