package ua.foxminded.java8api.columns;

public class LapCountColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.LapCountColumn;
    }

    @Override
    public Column get() {
        return new LapCountColumn();
    }
}
