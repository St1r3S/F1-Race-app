package ua.foxminded.java8api.columns;

public class TeamColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.TeamColumn;
    }

    @Override
    public Column get() {
        return new TeamColumn();
    }
}
