package treescrub.spedran.api.request;

import kong.unirest.HttpMethod;
import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import treescrub.spedran.requests.Requests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class ResourceRequest<T> {
    protected HttpRequest<?> request;
    protected CompletableFuture<T> result;
    private Map<String, Object> queryParameters;
    protected boolean completed = false;

    protected ResourceRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        request = Requests.getUnirestInstance().request(method.name(), url)
                .routeParam(routeParameters);
        queryParameters = new HashMap<>();
        result = new CompletableFuture<>();
    }

    public HttpRequest<?> getRequest() {
        return request;
    }

    public boolean isCompleted() {
        return completed;
    }

    public abstract void finishRequest(Object body);

    public void failRequest(Throwable throwable) {
        result.completeExceptionally(throwable);
    }

    public abstract HttpResponse<?> executeBlocking();

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

    protected void applyQueryParameters() {
        request.queryString(queryParameters);
    }

    public abstract CompletableFuture<T> complete();
}
