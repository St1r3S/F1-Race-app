package ua.foxminded.java8api.tables.impl;

import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AvgLapTimeTableDescriptor implements TableDescriptor {
    @Override
    public String getTitle() {
        return "Avg. Lap time";
    }

    @Override
    public List<ColumnType> getColumns() {
        return Arrays.asList(ColumnType.NUM, ColumnType.NAME, ColumnType.TEAM, ColumnType.AVG_LAP_TIME);
    }

    @Override
    public ColumnType getDefaultSortColumnType() {
        return ColumnType.AVG_LAP_TIME;
    }
}
