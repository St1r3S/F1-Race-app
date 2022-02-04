package ua.foxminded.java8api.columns.impl.suppliers;

import ua.foxminded.java8api.columns.Column;
import ua.foxminded.java8api.columns.ColumnSupplier;
import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.columns.impl.TeamColumn;

public class TeamColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.TEAM;
    }

    @Override
    public Column get() {
        return new TeamColumn();
    }
}
