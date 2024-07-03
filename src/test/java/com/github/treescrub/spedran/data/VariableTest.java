package com.github.treescrub.spedran.data;

import com.github.treescrub.spedran.JSONLoader;
import kong.unirest.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {

    @Test
    void getCategory() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variable");
        Variable variable = new Variable(json);

        assertFalse(variable.getCategory().isPresent());
    }

    @Test
    void getScope() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variable");
        Variable variable = new Variable(json);

        assertNotNull(variable.getScope());
    }

    @Test
    void isMandatory() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variable");
        Variable variable = new Variable(json);

        assertTrue(variable.isMandatory());
    }

    @Test
    void isUserDefined() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variable");
        Variable variable = new Variable(json);

        assertFalse(variable.isUserDefined());
    }

    @Test
    void isObsoleting() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variable");
        Variable variable = new Variable(json);

        assertTrue(variable.isObsoleting());
    }

    @Test
    void getValues() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variable");
        Variable variable = new Variable(json);

        assertFalse(variable.getValues().isEmpty());
        assertThrows(UnsupportedOperationException.class, () -> variable.getValues().clear());
    }

    @Test
    void getDefaultValue() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variable");
        Variable variable = new Variable(json);

        assertFalse(variable.getDefaultValue().isPresent());
    }

    @Test
    void isSubcategory() {
        JSONObject json = JSONLoader.getJsonTestFile("l4d/variable/variable");
        Variable variable = new Variable(json);

        assertFalse(variable.isSubcategory());
    }
}