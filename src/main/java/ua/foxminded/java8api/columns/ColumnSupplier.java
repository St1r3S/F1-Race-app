package ua.foxminded.java8api.columns;

import java.util.function.Supplier;

public interface ColumnSupplier extends Supplier<Column> {
    ColumnType getType();
}
