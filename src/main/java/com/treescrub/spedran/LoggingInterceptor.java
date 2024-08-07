package com.treescrub.spedran;

import kong.unirest.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
class LoggingInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

    private static String getShortenedUrl(String fullUrl) {
        if(!fullUrl.startsWith(Requests.BASE_URL)) {
            LOGGER.warn("URL '{}' does not start with base url '{}'", fullUrl, Requests.BASE_URL);
            return fullUrl;
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
            return;
        }

        LOGGER.debug("Received response from {} request to '{}'", request.getHttpMethod(), getShortenedUrl(request.getUrl()));

        Interceptor.super.onResponse(response, request, config);
    }

    @Override
    public HttpResponse<?> onFail(Exception e, HttpRequestSummary request, Config config) throws UnirestException {
        LOGGER.warn("{} request to '{}' failed to send", request.getHttpMethod(), getShortenedUrl(request.getUrl()));

        return Interceptor.super.onFail(e, request, config);
    }
}
