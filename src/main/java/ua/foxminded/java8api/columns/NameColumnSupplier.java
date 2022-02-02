package ua.foxminded.java8api.columns;

public class NameColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.NameColumn;
    }

    @Override
    public Column get() {
        return new NameColumn();
    }
}
