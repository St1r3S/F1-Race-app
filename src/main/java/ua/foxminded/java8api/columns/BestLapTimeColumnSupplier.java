package ua.foxminded.java8api.columns;

public class BestLapTimeColumnSupplier implements ColumnSupplier {
    @Override
    public ColumnType getType() {
        return ColumnType.BestLapTimeColumn;
    }

    @Override
    public Column get() {
        return new BestLapTimeColumn();
    }
}
