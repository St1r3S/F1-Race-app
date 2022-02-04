package ua.foxminded.java8api.tables.impl.suppliers;

import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableDescriptorSupplier;
import ua.foxminded.java8api.tables.TableType;
import ua.foxminded.java8api.tables.impl.BestLapTableDescriptor;

public class BestLapTableDescriptorSupplier implements TableDescriptorSupplier {
    @Override
    public TableType getType() {
        return TableType.BEST_LAP;
    }

    @Override
    public TableDescriptor get() {
        return new BestLapTableDescriptor();
    }
}
