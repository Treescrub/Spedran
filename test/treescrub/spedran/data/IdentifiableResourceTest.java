package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifiableResourceTest {

    private static final JSONObject json = new JSONObject("{\"id\":\"id\"}");

    @Test
    void getId() {
        IdentifiableResource resource = new IdentifiableResource(json);

        assertEquals("id", resource.getId());
    }
}