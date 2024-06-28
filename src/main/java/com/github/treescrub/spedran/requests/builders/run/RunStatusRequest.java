package com.github.treescrub.spedran.requests.builders.run;

import com.github.treescrub.spedran.data.Run;
import com.github.treescrub.spedran.data.SubmissionStatus;
import com.github.treescrub.spedran.requests.InvalidBuilderStateException;
import com.github.treescrub.spedran.requests.ModifyResourceRequest;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONElement;
import kong.unirest.json.JSONObject;

import java.util.Map;

/**
 * A request builder to reject or verify a run.
 */
public class RunStatusRequest extends ModifyResourceRequest<Run> {
    private SubmissionStatus statusType;
    private String rejectionReason;

    public RunStatusRequest(String id) {
        super(HttpMethod.PUT, "runs/{id}/status", Map.of("id", id));
    }

    public RunStatusRequest(Run run) {
        this(run.getId());
    }

    /**
     * Sets the status of the {@link Run} to {@link SubmissionStatus#VERIFIED}.
     *
     * @return this builder object
     */
    public RunStatusRequest verify() {
        statusType = SubmissionStatus.VERIFIED;

        return this;
    }

    /**
     * Sets the status of the {@link Run} to {@link SubmissionStatus#REJECTED} with the provided rejection reason.
     *
     * @param reason a {@code String} with the reason for this run being rejected
     * @return this builder object
     */
    public RunStatusRequest reject(String reason) {
        statusType = SubmissionStatus.REJECTED;
        rejectionReason = reason;

        return this;
    }

    @Override
    protected Class<Run> getDataClass() {
        return Run.class;
    }

    @Override
    protected JSONElement buildBody() throws InvalidBuilderStateException {
        if(statusType == null) {
            throw new InvalidBuilderStateException("The status type was not set");
        }

        JSONObject statusNode = new JSONObject();
        statusNode.put("status", statusType.toAPIName());

        if(statusType == SubmissionStatus.REJECTED) {
            statusNode.put("reason", rejectionReason);
        }

        JSONObject rootNode = new JSONObject();
        rootNode.put("status", statusNode);

        return rootNode;
    }
}
