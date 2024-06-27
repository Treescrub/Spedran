package com.github.treescrub.spedran.requests;

import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;

/**
 * An exception that represents a failed request to the API.
 */
public class HttpRequestException extends Exception {
    public HttpRequestException(int statusCode, String statusText, String method, String url) {
        super("Request to '" + url + "' with method " + method + " failed (" + statusCode + ": " + statusText + ")");
    }

    HttpRequestException(HttpResponse<?> httpResponse, HttpRequest<?> httpRequest) {
        this(httpResponse.getStatus(), httpResponse.getStatusText(), httpRequest.getHttpMethod().name(), httpRequest.getUrl());
    }
}
