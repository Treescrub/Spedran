package treescrub.spedran.data.filterbuilder;

public class VariablesFilterBuilder extends FilterBuilder {

    public VariablesFilterBuilder sortByName() {
        setOption("orderby", "name");
        return this;
    }

    public VariablesFilterBuilder sortByMandatory() {
        setOption("orderby", "mandatory");
        return this;
    }

    public VariablesFilterBuilder sortByUserDefined() {
        setOption("orderby", "user-defined");
        return this;
    }

    public VariablesFilterBuilder sortByPosition() {
        setOption("orderby", "pos");
        return this;
    }

    public VariablesFilterBuilder sortAscending() {
        setOption("direction", "asc");
        return this;
    }

    public VariablesFilterBuilder sortDescending() {
        setOption("direction", "desc");
        return this;
    }
}
