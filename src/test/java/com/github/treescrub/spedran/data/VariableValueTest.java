package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableValueTest {

    @Test
    void getLabel() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variablevalue");
        VariableValue variableValue = new VariableValue(json);

        assertEquals("Newest", variableValue.getLabel());
    }

    @Test
    void getRules() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variablevalue");
        VariableValue variableValue = new VariableValue(json);

        assertFalse(variableValue.getRules().isPresent());
    }

    @Test
    void getFlags() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variablevalue");
        VariableValue variableValue = new VariableValue(json);

        assertTrue(variableValue.getFlags().isEmpty());
    }
}