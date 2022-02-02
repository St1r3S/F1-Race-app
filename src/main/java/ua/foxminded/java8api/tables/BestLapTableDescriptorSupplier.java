package ua.foxminded.java8api.tables;

public class BestLapTableDescriptorSupplier implements TableDescriptorSupplier {
    @Override
    public TableType getType() {
        return TableType.BestLapTable;
    }

    @Override
    public TableDescriptor get() {
        return new BestLapTableDescriptor();
    }
}
