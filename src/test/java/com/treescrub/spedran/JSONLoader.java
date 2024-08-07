package com.treescrub.spedran;

import kong.unirest.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JSONLoader {
    public static JSONObject getJsonTestFile(String path) {
        path = "src/test/resources/" + path + ".json";
        String jsonString = null;
        try {
            jsonString = Files.readString(new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(jsonString);
    }
}
