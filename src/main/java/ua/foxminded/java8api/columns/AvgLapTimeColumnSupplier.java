package ua.foxminded.java8api.columns;

public class AvgLapTimeColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.AvgLapTimeColumn;
    }

    @Override
    public Column get() {
        return new AvgLapTimeColumn();
    }
}
