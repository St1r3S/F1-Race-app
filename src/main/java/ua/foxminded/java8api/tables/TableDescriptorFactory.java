package ua.foxminded.java8api.tables;


import ua.foxminded.java8api.tables.impl.suppliers.AvgLapTimeTableDescriptorSupplier;
import ua.foxminded.java8api.tables.impl.suppliers.BestLapTableDescriptorSupplier;
import ua.foxminded.java8api.tables.impl.suppliers.LapCountTableDescriptorSupplier;
import ua.foxminded.java8api.tables.impl.suppliers.NameTableDescriptorSupplier;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class TableDescriptorFactory {

    private final Map<TableType, TableDescriptorSupplier> descriptorMap;

    public TableDescriptorFactory() {
        this.descriptorMap = Stream.of(
                new AvgLapTimeTableDescriptorSupplier(),
                new BestLapTableDescriptorSupplier(),
                new LapCountTableDescriptorSupplier(),
                new NameTableDescriptorSupplier()
        ).collect(toMap(d -> d.getType(), d -> d));
    }

    public TableDescriptor getTable(TableType type) {
        TableDescriptorSupplier tableDescriptorSupplier = descriptorMap.get(type);
        if (tableDescriptorSupplier == null) {
            throw new IllegalArgumentException("Unknown table type "+type.name());
        }
        return tableDescriptorSupplier.get();
    }
}
