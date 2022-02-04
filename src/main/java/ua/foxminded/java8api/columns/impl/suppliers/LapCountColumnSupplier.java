package ua.foxminded.java8api.columns.impl.suppliers;

import ua.foxminded.java8api.columns.Column;
import ua.foxminded.java8api.columns.ColumnSupplier;
import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.columns.impl.LapCountColumn;

public class LapCountColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.LAP_COUNT;
    }

    @Override
    public Column get() {
        return new LapCountColumn();
    }
}
