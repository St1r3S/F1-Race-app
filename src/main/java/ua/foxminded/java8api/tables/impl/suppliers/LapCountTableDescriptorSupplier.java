package ua.foxminded.java8api.tables.impl.suppliers;

import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableDescriptorSupplier;
import ua.foxminded.java8api.tables.TableType;
import ua.foxminded.java8api.tables.impl.LapCountTableDescriptor;

public class LapCountTableDescriptorSupplier implements TableDescriptorSupplier {
    @Override
    public TableType getType() {
        return TableType.LAP_COUNT;
    }

    @Override
    public TableDescriptor get() {
        return new LapCountTableDescriptor();
    }
}
