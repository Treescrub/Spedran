package treescrub.spedran.requests;

import kong.unirest.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingInterceptor implements Interceptor {
    private static final Logger LOGGER = LogManager.getLogger(LoggingInterceptor.class);

    private static String getShortenedUrl(String fullUrl) {
        if(!fullUrl.startsWith(Requests.BASE_URL)) {
            LOGGER.error("URL '{}' does not start with base url '{}'", fullUrl, Requests.BASE_URL);
            return null;
        }

        return fullUrl.substring(Requests.BASE_URL.length());
    }

    @Override
    public void onRequest(HttpRequest<?> request, Config config) {
        LOGGER.debug("Sending {} request to '{}'", request.getHttpMethod(), getShortenedUrl(request.getUrl()));

        Interceptor.super.onRequest(request, config);
    }

    @Override
    public void onResponse(HttpResponse<?> response, HttpRequestSummary request, Config config) {
        if(!response.isSuccess()) {
            LOGGER.warn("{} request to '{}' failed with '{}: {}'", request.getHttpMethod(), getShortenedUrl(request.getUrl()), response.getStatus(), response.getStatusText());
        }

        LOGGER.debug("Received response from {} request to '{}'", request.getHttpMethod(), getShortenedUrl(request.getUrl()));

        Interceptor.super.onResponse(response, request, config);
    }

    @Override
    public HttpResponse<?> onFail(Exception e, HttpRequestSummary request, Config config) throws UnirestException {
        LOGGER.warn("{} request to {} failed to send", request.getHttpMethod(), getShortenedUrl(request.getUrl()));

        return Interceptor.super.onFail(e, request, config);
    }
}
