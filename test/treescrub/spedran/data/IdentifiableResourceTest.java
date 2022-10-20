package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifiableResourceTest {

    @Test
    void getId() {
        JSONObject json = JSONLoader.getJsonTestFile("IdentifiableResource/id");
        IdentifiableResource resource = new IdentifiableResource(json);

        assertEquals("id", resource.getId());
    }
}