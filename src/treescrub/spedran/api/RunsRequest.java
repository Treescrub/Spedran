package treescrub.spedran.api;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.data.run.Run;
import treescrub.spedran.data.run.SubmissionStatus;

import java.util.function.Function;

public class RunsRequest extends ResourceCollectionRequest<Run> {
    public RunsRequest() {
        super(HttpMethod.GET, "runs");
    }

    public RunsRequest user(String id) {
        setParameter("user", id);
        return this;
    }

    public RunsRequest guest(String name) {
        setParameter("guest", name);
        return this;
    }

    public RunsRequest verifier(String id) {
        setParameter("examiner", id);
        return this;
    }

    public RunsRequest game(String id) {
        setParameter("game", id);
        return this;
    }

    public RunsRequest level(String id) {
        setParameter("level", id);
        return this;
    }

    public RunsRequest category(String id) {
        setParameter("category", id);
        return this;
    }

    public RunsRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public RunsRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    public RunsRequest emulated(boolean isEmulated) {
        setParameter("emulated", isEmulated);
        return this;
    }

    public RunsRequest status(SubmissionStatus submissionStatus) {
        setParameter("status", submissionStatus.name().toLowerCase());
        return this;
    }

    public RunsRequest sortByGame() {
        setSortParameter("game");
        return this;
    }

    public RunsRequest sortByCategory() {
        setSortParameter("category");
        return this;
    }

    public RunsRequest sortByLevel() {
        setSortParameter("level");
        return this;
    }

    public RunsRequest sortByPlatform() {
        setSortParameter("platform");
        return this;
    }

    public RunsRequest sortByRegion() {
        setSortParameter("region");
        return this;
    }

    public RunsRequest sortByEmulation() {
        setSortParameter("emulated");
        return this;
    }

    public RunsRequest sortByDate() {
        setSortParameter("date");
        return this;
    }

    public RunsRequest sortBySubmissionDate() {
        setSortParameter("submitted");
        return this;
    }

    public RunsRequest sortByVerificationStatus() {
        setSortParameter("status");
        return this;
    }

    public RunsRequest sortByVerificationDate() {
        setSortParameter("verify-date");
        return this;
    }

    @Override
    protected Function<JSONObject, Run> getConstructor() {
        return Run::new;
    }
}
