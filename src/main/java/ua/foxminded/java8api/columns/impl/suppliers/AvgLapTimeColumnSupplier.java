package ua.foxminded.java8api.columns.impl.suppliers;

import ua.foxminded.java8api.columns.Column;
import ua.foxminded.java8api.columns.ColumnSupplier;
import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.columns.impl.AvgLapTimeColumn;

public class AvgLapTimeColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.AVG_LAP_TIME;
    }

    @Override
    public Column get() {
        return new AvgLapTimeColumn();
    }
}
