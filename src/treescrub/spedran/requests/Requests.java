package treescrub.spedran.requests;

import kong.unirest.Unirest;
import kong.unirest.UnirestInstance;

public class Requests {
    public static final String BASE_URL = "https://www.speedrun.com/api/v1/";

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

    public static UnirestInstance getUnirestInstance() {
        return unirestInstance;
    }
}
