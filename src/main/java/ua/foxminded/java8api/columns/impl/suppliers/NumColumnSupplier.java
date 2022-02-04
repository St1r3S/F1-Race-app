package ua.foxminded.java8api.columns.impl.suppliers;

import ua.foxminded.java8api.columns.Column;
import ua.foxminded.java8api.columns.ColumnSupplier;
import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.columns.impl.NumColumn;

public class NumColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.NUM;
    }

    @Override
    public Column get() {
        return new NumColumn();
    }
}
