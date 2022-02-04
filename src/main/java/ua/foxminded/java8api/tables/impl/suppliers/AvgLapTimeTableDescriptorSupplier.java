package ua.foxminded.java8api.tables.impl.suppliers;

import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableDescriptorSupplier;
import ua.foxminded.java8api.tables.TableType;
import ua.foxminded.java8api.tables.impl.AvgLapTimeTableDescriptor;

public class AvgLapTimeTableDescriptorSupplier implements TableDescriptorSupplier {
    @Override
    public TableType getType() {
        return TableType.AVG_LAP_TIME;
    }

    @Override
    public TableDescriptor get() {
        return new AvgLapTimeTableDescriptor();
    }
}
