package ua.foxminded.java8api.tables;

import java.util.function.Supplier;

public interface TableDescriptorSupplier extends Supplier<TableDescriptor> {
    TableType getType();
}
