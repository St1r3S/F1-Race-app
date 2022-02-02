package ua.foxminded.java8api.tables;

public class LapCountTableDescriptorSupplier implements TableDescriptorSupplier {
    @Override
    public TableType getType() {
        return TableType.LapCountTable;
    }

    @Override
    public TableDescriptor get() {
        return new LapCountTableDescriptor();
    }
}
