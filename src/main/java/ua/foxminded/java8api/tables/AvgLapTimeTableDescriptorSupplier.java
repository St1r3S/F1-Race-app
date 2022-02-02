package ua.foxminded.java8api.tables;

public class AvgLapTimeTableDescriptorSupplier implements TableDescriptorSupplier {
    @Override
    public TableType getType() {
        return TableType.AvgLapTimeTable;
    }

    @Override
    public TableDescriptor get() {
        return new AvgLapTimeTableDescriptor();
    }
}
