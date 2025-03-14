package com.treescrub.spedran;

import kong.unirest.HttpMethod;
import kong.unirest.HttpRequest;
import kong.unirest.HttpRequestWithBody;
import kong.unirest.HttpResponse;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

abstract class ResourceRequest<T> {
    protected HttpRequestWithBody request;
    protected final CompletableFuture<T> result;
    private final Map<String, Object> queryParameters;
    protected boolean completed = false;
    private final Set<String> embeds;

    @SuppressWarnings("unused")
    protected ResourceRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        request = Requests.request(method, url).routeParam(routeParameters);
        queryParameters = new HashMap<>();
        result = new CompletableFuture<>();
        embeds = new HashSet<>();
    }

    HttpRequest<?> getRequest() {
        return request;
    }

    boolean isCompleted() {
        return completed;
    }

    abstract void finishRequest(Object body);

    void failRequest(Throwable throwable) {
        result.completeExceptionally(throwable);
    }

    abstract HttpResponse<?> executeBlocking();

    @SuppressWarnings("unused")
    protected ResourceRequest(HttpMethod method, String url) {
        this(method, url, Map.of());
    }

    private void rawSetParameter(String key, Object value) {
        queryParameters.put(key, value);
    }

    protected void setParameter(String key, String value) {
        rawSetParameter(key, value);
    }

    protected void setParameter(String key, int value) {
        rawSetParameter(key, value);
    }

    protected void setParameter(String key, boolean value) {
        rawSetParameter(key, value);
    }

    protected void addEmbed(String embed) {
        embeds.add(embed);
    }

    protected void addEmbed(Collection<String> embeds, String resourceName) {
        String joinedEmbeds = embeds.stream()
                .map(embedString -> resourceName + "." + embedString)
                .collect(Collectors.joining(","));

        addEmbed(joinedEmbeds);
    }

    protected void applyQueryParameters() {
        request.queryString(queryParameters);
        if(!embeds.isEmpty()) {
            request.queryString("embed", String.join(",", embeds));
        }
    }

    @SuppressWarnings("unused")
    public abstract CompletableFuture<T> complete();
}
