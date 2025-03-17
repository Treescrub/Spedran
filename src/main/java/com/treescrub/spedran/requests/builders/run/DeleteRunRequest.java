package com.treescrub.spedran.requests.builders.run;

import com.treescrub.spedran.data.Run;
import com.treescrub.spedran.ModifyResourceRequest;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONElement;

import java.util.Map;

/**
 * A request builder to delete a {@link Run} from SRC.
 */
public class DeleteRunRequest extends ModifyResourceRequest<Run> {
    @SuppressWarnings("unused")
    protected DeleteRunRequest(String id) {
        super(HttpMethod.DELETE, "runs/{id}", Map.of("id", id));
    }

    /**
     * Creates and returns a new {@code DeleteRunRequest} builder.
     *
     * @param run the run to be deleted
     * @return a {@code DeleteRunRequest} builder
     */
    public static DeleteRunRequest create(Run run) {
        checkResource(run, "run");

        return new DeleteRunRequest(run.getId());
    }

    /**
     * Creates and returns a new {@code DeleteRunRequest} builder.
     *
     * @param id the run to be deleted
     * @return a {@code DeleteRunRequest} builder
     */
    public static DeleteRunRequest create(String id) {
        checkId(id);

        return new DeleteRunRequest(id);
    }


    @Override
    protected Class<Run> getDataClass() {
        return Run.class;
    }

    @Override
    protected JSONElement buildBody() {
        return null;
    }
}
