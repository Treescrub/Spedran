package com.github.treescrub.spedran.requests;

import kong.unirest.HttpMethod;
import kong.unirest.HttpRequest;
import kong.unirest.Unirest;
import kong.unirest.UnirestInstance;

public class Requests {
    public static final String BASE_URL = "https://www.speedrun.com/api/v1/";

    private static String key;
    private static UnirestInstance unirestInstance;

    static {
        setup();
    }

    private static void setup() {
        unirestInstance = Unirest.spawnInstance();
        unirestInstance.config().addDefaultHeader("User-Agent", "Spedran/1.0");
        unirestInstance.config().defaultBaseUrl(BASE_URL);
        unirestInstance.config().interceptor(new LoggingInterceptor());
    }

    public static HttpRequest<?> request(HttpMethod method, String url) {
        HttpRequest<?> httpRequest = unirestInstance.request(method.name(), url);
        if(key != null) {
            httpRequest.header("X-Api-Key", key);
        }

        return httpRequest;
    }

    public static void setKey(String newKey) {
        key = newKey;
    }

    public static void clearKey() {
        key = null;
    }
}
