package treescrub.spedran.data;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifiableNamedResourceTest {

    @Test
    void getName() {
        JSONObject json = JSONLoader.getJsonTestFile("IdentifiableNamedResource/name");
        IdentifiableNamedResource resource = new IdentifiableNamedResource(json);

        assertEquals("name", resource.getName());
    }
}