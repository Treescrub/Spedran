package com.github.treescrub.spedran.requests.run;

import com.github.treescrub.spedran.requests.InvalidBuilderStateException;
import com.github.treescrub.spedran.requests.ModifyResourceRequest;
import com.github.treescrub.spedran.data.run.Run;
import com.github.treescrub.spedran.data.run.SubmissionStatus;
import kong.unirest.HttpMethod;
import kong.unirest.json.JSONElement;
import kong.unirest.json.JSONObject;

import java.util.Map;

public class RunStatusRequest extends ModifyResourceRequest<Void> {
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
    protected Void parse(JSONObject data) {
        return null;
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
