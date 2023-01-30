package treescrub.spedran.api;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.run.Run;

import java.util.function.Function;

public class RunsRequest extends ResourceCollectionRequest<Run> {
    public RunsRequest() {
        super(HttpMethod.GET, "runs");
    }

    public RunsRequest game(String id) {
        setParameter("game", id);
        return this;
    }

    public RunsRequest verifier(String id) {
        setParameter("examiner", id);
        return this;
    }

    @Override
    protected Function<JSONObject, Run> getConstructor() {
        return Run::new;
    }
}
