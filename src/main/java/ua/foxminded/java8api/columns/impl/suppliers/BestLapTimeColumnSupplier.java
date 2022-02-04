package ua.foxminded.java8api.columns.impl.suppliers;

import ua.foxminded.java8api.columns.Column;
import ua.foxminded.java8api.columns.ColumnSupplier;
import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.columns.impl.BestLapTimeColumn;

public class BestLapTimeColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.BEST_LAP;
    }

    @Override
    public Column get() {
        return new BestLapTimeColumn();
    }
}
