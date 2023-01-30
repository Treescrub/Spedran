package treescrub.spedran.api;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class SingleResourceRequest<T> extends ResourceRequest<T> {
    protected SingleResourceRequest(HttpMethod method, String url, Map<String, Object> routeParameters) {
        super(method, url, routeParameters);
    }

    protected SingleResourceRequest(HttpMethod method, String url) {
        super(method, url);
    }

    @Override
    public CompletableFuture<T> complete() {
        applyQueryParameters();
        return getRequest()
                .asJsonAsync()
                .thenApply(response -> parse(response.getBody().getObject()));
    }

    protected abstract T parse(JSONObject data);
}
