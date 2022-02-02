package ua.foxminded.java8api.tables;

public class NameTableDescriptorSupplier implements TableDescriptorSupplier {
    @Override
    public TableType getType() {
        return TableType.NameTable;
    }

    @Override
    public TableDescriptor get() {
        return new NameTableDescriptor();
    }
}
