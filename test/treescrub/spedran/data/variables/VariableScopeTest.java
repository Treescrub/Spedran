package treescrub.spedran.data.variables;

import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;
import treescrub.spedran.data.JSONLoader;

import static org.junit.jupiter.api.Assertions.*;

class VariableScopeTest {

    @Test
    void getType() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variablescope");
        VariableScope variableScope = new VariableScope(json);

        assertEquals(VariableScope.ScopeType.GLOBAL, variableScope.getType());
    }

    @Test
    void getLevel() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variablescope");
        VariableScope variableScope = new VariableScope(json);

        assertFalse(variableScope.getLevel().isPresent());
    }
}