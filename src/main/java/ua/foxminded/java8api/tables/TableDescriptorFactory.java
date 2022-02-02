package ua.foxminded.java8api.tables;


public class TableDescriptorFactory {
    public TableDescriptor getTable(TableType type) {
        if (TableType.LapCountTable == type) {
            TableDescriptorSupplier supplier = new LapCountTableDescriptorSupplier();
            return supplier.get();
        } else if (TableType.AvgLapTimeTable == type) {
            TableDescriptorSupplier supplier = new AvgLapTimeTableDescriptorSupplier();
            return supplier.get();
        } else if (TableType.NameTable == type) {
            TableDescriptorSupplier supplier = new NameTableDescriptorSupplier();
            return supplier.get();
        } else if (TableType.BestLapTable == type) {
            TableDescriptorSupplier supplier = new BestLapTableDescriptorSupplier();
            return supplier.get();
        } else {
            throw new IllegalArgumentException(type.toString() + "unknown type");
        }
    }
}
