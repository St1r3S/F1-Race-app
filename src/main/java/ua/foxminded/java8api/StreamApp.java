package ua.foxminded.java8api;

import ua.foxminded.java8api.columns.ColumnFactory;
import ua.foxminded.java8api.formatter.Formatter;
import ua.foxminded.java8api.model.*;
import ua.foxminded.java8api.parser.LapTimeRecordMapper;
import ua.foxminded.java8api.parser.TeamRacerRecordMapper;
import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableDescriptorFactory;
import ua.foxminded.java8api.tables.TableType;

import java.util.List;

public class StreamApp {
    public static void main(String[] args) {

        List<RacerRecord> teamNameRecords = ModelLoader.loadModel(new TeamRacerRecordMapper(), "abbreviations.txt");
        List<LapTimeRecord> lapTimeRecords = ModelLoader.loadModel(new LapTimeRecordMapper(), "start.log.txt", "end.log.txt");
        List<Racer> racers = ModelBuilder.buildModel(teamNameRecords, lapTimeRecords);


        Formatter formatter = new Formatter(new ColumnFactory());
        TableDescriptorFactory tableDescriptorFactory = new TableDescriptorFactory();

        for (TableType type : TableType.values()) {
            TableDescriptor descriptor = tableDescriptorFactory.getTable(type);
            System.out.println(">> " + descriptor.getTitle() + " <<");
            System.out.println(formatter.format(descriptor, racers));
            System.out.println("\n\n\n");
        }
    }
}
