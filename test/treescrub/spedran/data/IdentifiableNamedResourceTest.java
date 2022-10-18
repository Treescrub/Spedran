package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifiableNamedResourceTest {

    private static final JSONObject json = new JSONObject("{\"id\":\"id\",\"name\":\"name\"}");

    @Test
    void getName() {
        IdentifiableNamedResource resource = new IdentifiableNamedResource(json);

        assertEquals("name", resource.getName());
    }
}