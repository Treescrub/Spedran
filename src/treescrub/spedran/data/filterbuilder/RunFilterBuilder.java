package treescrub.spedran.data.filterbuilder;

import treescrub.spedran.data.Guest;
import treescrub.spedran.data.Level;
import treescrub.spedran.data.Platform;
import treescrub.spedran.data.Region;
import treescrub.spedran.data.category.Category;
import treescrub.spedran.data.game.Game;
import treescrub.spedran.data.run.SubmissionStatus;
import treescrub.spedran.data.user.User;

public class RunFilterBuilder extends FilterBuilder {

    public RunFilterBuilder user(String id) {
        setOption("user", id);
        return this;
    }

    public RunFilterBuilder user(User value) {
        return user(value.getId());
    }

    public RunFilterBuilder guest(String name) {
        setOption("guest", name);
        return this;
    }

    public RunFilterBuilder guest(Guest value) {
        return guest(value.getName());
    }

    public RunFilterBuilder examiner(String id) {
        setOption("examiner", id);
        return this;
    }

    public RunFilterBuilder examiner(User value) {
        return examiner(value.getId());
    }

    public RunFilterBuilder game(String id) {
        setOption("game", id);
        return this;
    }

    public RunFilterBuilder game(Game value) {
        return game(value.getId());
    }

    public RunFilterBuilder level(String id) {
        setOption("level", id);
        return this;
    }

    public RunFilterBuilder level(Level value) {
        return level(value.getId());
    }

    public RunFilterBuilder category(String id) {
        setOption("category", id);
        return this;
    }

    public RunFilterBuilder category(Category value) {
        return category(value.getId());
    }

    public RunFilterBuilder platform(String id) {
        setOption("platform", id);
        return this;
    }

    public RunFilterBuilder platform(Platform value) {
        return platform(value.getId());
    }

    public RunFilterBuilder region(String id) {
        setOption("region", id);
        return this;
    }

    public RunFilterBuilder region(Region value) {
        return region(value.getId());
    }

    public RunFilterBuilder emulated(boolean value) {
        setOption("emulated", value);
        return this;
    }

    public RunFilterBuilder status(SubmissionStatus value) {
        setOption("status", value.name().toLowerCase());
        return this;
    }

    public RunFilterBuilder sortByGame() {
        setOption("orderby", "game");
        return this;
    }

    public RunFilterBuilder sortByCategory() {
        setOption("orderby", "category");
        return this;
    }

    public RunFilterBuilder sortByLevel() {
        setOption("orderby", "level");
        return this;
    }

    public RunFilterBuilder sortByPlatform() {
        setOption("orderby", "platform");
        return this;
    }

    public RunFilterBuilder sortByRegion() {
        setOption("orderby", "region");
        return this;
    }

    public RunFilterBuilder sortByEmulation() {
        setOption("orderby", "emulated");
        return this;
    }

    public RunFilterBuilder sortByDate() {
        setOption("orderby", "date");
        return this;
    }

    public RunFilterBuilder sortBySubmissionDate() {
        setOption("orderby", "submitted");
        return this;
    }

    public RunFilterBuilder sortByStatus() {
        setOption("orderby", "status");
        return this;
    }

    public RunFilterBuilder sortByVerifyDate() {
        setOption("orderby", "verify-date");
        return this;
    }

    public RunFilterBuilder sortAscending() {
        setOption("direction", "asc");
        return this;
    }

    public RunFilterBuilder sortDescending() {
        setOption("direction", "desc");
        return this;
    }
}
