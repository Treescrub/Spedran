package treescrub.spedran.api.request.run;

import kong.unirest.HttpMethod;
import kong.unirest.json.JSONObject;
import treescrub.spedran.api.request.ResourceCollectionRequest;
import treescrub.spedran.api.request.SortDirection;
import treescrub.spedran.data.Guest;
import treescrub.spedran.data.Level;
import treescrub.spedran.data.Platform;
import treescrub.spedran.data.Region;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.run.Run;
import treescrub.spedran.data.run.SubmissionStatus;
import treescrub.spedran.data.user.User;

import java.util.function.Function;

public class RunsRequest extends ResourceCollectionRequest<Run> {
    public RunsRequest() {
        super(HttpMethod.GET, "runs");
    }

    public RunsRequest user(String id) {
        setParameter("user", id);
        return this;
    }

    public RunsRequest user(User user) {
        return user(user.getId());
    }

    public RunsRequest guest(String name) {
        setParameter("guest", name);
        return this;
    }

    public RunsRequest guest(Guest guest) {
        return guest(guest.getName());
    }

    public RunsRequest verifier(String id) {
        setParameter("examiner", id);
        return this;
    }

    public RunsRequest verifier(User user) {
        return verifier(user.getId());
    }

    public RunsRequest game(String id) {
        setParameter("game", id);
        return this;
    }

    public RunsRequest game(Game game) {
        return game(game.getId());
    }

    public RunsRequest level(String id) {
        setParameter("level", id);
        return this;
    }

    public RunsRequest level(Level level) {
        return level(level.getId());
    }

    public RunsRequest category(String id) {
        setParameter("category", id);
        return this;
    }

    public RunsRequest category(Category category) {
        return category(category.getId());
    }

    public RunsRequest platform(String id) {
        setParameter("platform", id);
        return this;
    }

    public RunsRequest platform(Platform platform) {
        return platform(platform.getId());
    }

    public RunsRequest region(String id) {
        setParameter("region", id);
        return this;
    }

    public RunsRequest region(Region region) {
        return region(region.getId());
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

    public RunsRequest sortDirection(SortDirection direction) {
        setSortDirection(direction);
        return this;
    }

    @Override
    protected Function<JSONObject, Run> getConstructor() {
        return Run::new;
    }
}
