package ua.foxminded.java8api.columns;

public class ColumnFactory {
    public Column getColumn(ColumnType type) {
        if (ColumnType.AvgLapTimeColumn == type) {
            ColumnSupplier supplier = new AvgLapTimeColumnSupplier();
            return supplier.get();
        } else if (ColumnType.BestLapTimeColumn == type) {
            ColumnSupplier supplier = new BestLapTimeColumnSupplier();
            return supplier.get();
        } else if (ColumnType.LapCountColumn == type) {
            ColumnSupplier supplier = new LapCountColumnSupplier();
            return supplier.get();
        } else if (ColumnType.NameColumn == type) {
            ColumnSupplier supplier = new NameColumnSupplier();
            return supplier.get();
        } else if (ColumnType.TeamColumn == type) {
            ColumnSupplier supplier = new TeamColumnSupplier();
            return supplier.get();
        } else {
            throw new IllegalArgumentException(type.toString() + "unknown type");
        }
    }
}
