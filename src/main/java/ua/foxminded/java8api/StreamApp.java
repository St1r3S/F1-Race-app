package ua.foxminded.java8api;

import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableDescriptorFactory;
import ua.foxminded.java8api.tables.TableType;

import java.util.List;

public class StreamApp {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        Parser parser = new Parser();
        TableDescriptorFactory tableDescriptorFactory = new TableDescriptorFactory();

        List<Racer> racers = parser.parseRacer(parser.parseAbbreviations(), parser.parseLaps());
        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.BestLapTable);

        System.out.println(formatter.format(descriptor, racers));

    }
}
