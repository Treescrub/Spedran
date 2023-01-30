package treescrub.spedran.api;

import kong.unirest.HttpMethod;
import kong.unirest.HttpRequest;
import treescrub.spedran.requests.Requests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class ResourceRequest<T> {
    private HttpRequest<?> request;
    private Map<String, Object> queryParameters;

    protected ResourceRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        request = Requests.getUnirestInstance().request(method.name(), url)
                .routeParam(routeParameters);
        queryParameters = new HashMap<>();
    }

    protected ResourceRequest(HttpMethod method, String url) {
        this(method, url, new HashMap<>());
    }

    protected void setParameter(String key, Object value) {
        queryParameters.put(key, value);
    }

    protected void applyQueryParameters() {
        request.queryString(queryParameters);
    }

    protected HttpRequest<?> getRequest() {
        return request;
    }

    protected abstract CompletableFuture<T> complete();
}
