package ua.foxminded.java8api.tables;

import ua.foxminded.java8api.columns.ColumnType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NameTableDescriptor implements TableDescriptor {
    @Override
    public String getTitle() {
        return TableType.NameTable.toString();
    }

    @Override
    public List<ColumnType> getColumns() {
        return new LinkedList<>(Arrays.asList(ColumnType.NameColumn));
    }

    @Override
    public ColumnType getDefaultSortColumnType() {
        return ColumnType.NameColumn;
    }
}
