package ua.foxminded.java8api.tables;

import ua.foxminded.java8api.columns.ColumnType;

import java.util.List;

public interface TableDescriptor {
    String getTitle();

    List<ColumnType> getColumns();

    ColumnType getDefaultSortColumnType();

}
