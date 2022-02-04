package ua.foxminded.java8api.tables.impl;

import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BestLapTableDescriptor implements TableDescriptor {
    @Override
    public String getTitle() {
        return "Best Lap time";
    }

    @Override
    public List<ColumnType> getColumns() {
        return Arrays.asList(ColumnType.NUM, ColumnType.NAME, ColumnType.TEAM, ColumnType.BEST_LAP);
    }

    @Override
    public ColumnType getDefaultSortColumnType() {
        return ColumnType.BEST_LAP;
    }
}
