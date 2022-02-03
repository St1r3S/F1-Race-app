package ua.foxminded.java8api;

import ua.foxminded.java8api.columns.ColumnFactory;
import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.tables.TableDescriptorFactory;
import ua.foxminded.java8api.tables.TableType;

import java.util.ArrayList;
import java.util.List;

public class StreamApp {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        Parser parser = new Parser();
        TableDescriptorFactory tableDescriptorFactory = new TableDescriptorFactory();


        List<Racer> racers = parser.parseRacer(parser.parseAbbreviations(), parser.parseLaps());
        ColumnFactory columnFactory = new ColumnFactory();
        List<ColumnType> columnTypes = tableDescriptorFactory.getTable(TableType.BestLapTable).getColumns();
        System.out.println(formatter.format(tableDescriptorFactory, columnTypes, columnFactory, racers, TableType.BestLapTable));

    }
}
