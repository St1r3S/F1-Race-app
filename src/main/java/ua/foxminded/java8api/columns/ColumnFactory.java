package ua.foxminded.java8api.columns;

import ua.foxminded.java8api.columns.impl.suppliers.*;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class ColumnFactory {
    private Map<ColumnType, ColumnSupplier> supplierMap;

    public ColumnFactory() {
        supplierMap = Stream.of(
                new AvgLapTimeColumnSupplier(),
                new BestLapTimeColumnSupplier(),
                new LapCountColumnSupplier(),
                new NameColumnSupplier(),
                new NumColumnSupplier(),
                new TeamColumnSupplier()
        ).collect(toMap(s -> s.getType(), s -> s));

    }

    public Column getColumn(ColumnType type) {
        ColumnSupplier columnSupplier = supplierMap.get(type);
        if (columnSupplier == null) {
            throw new IllegalArgumentException("Unknown column type " + type.name());
        }
        return columnSupplier.get();
    }
}
