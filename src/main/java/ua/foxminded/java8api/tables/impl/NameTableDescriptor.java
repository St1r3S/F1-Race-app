package ua.foxminded.java8api.tables.impl;

import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.tables.TableDescriptor;

import java.util.Arrays;
import java.util.List;

public class NameTableDescriptor implements TableDescriptor {
    @Override
    public String getTitle() {
        return "Racers list";
    }

    @Override
    public List<ColumnType> getColumns() {
        return Arrays.asList(ColumnType.NUM, ColumnType.NAME);
    }

    @Override
    public ColumnType getDefaultSortColumnType() {
        return ColumnType.NAME;
    }
}
