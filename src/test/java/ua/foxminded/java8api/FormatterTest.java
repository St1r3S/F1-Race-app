package ua.foxminded.java8api;

import org.junit.jupiter.api.Test;
import ua.foxminded.java8api.columns.ColumnFactory;
import ua.foxminded.java8api.formatter.Formatter;
import ua.foxminded.java8api.model.*;
import ua.foxminded.java8api.parser.LapTimeRecordMapper;
import ua.foxminded.java8api.parser.TeamRacerRecordMapper;
import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableDescriptorFactory;
import ua.foxminded.java8api.tables.TableType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {

    List<RacerRecord> teamNameRecords = ModelLoader.loadModel(new TeamRacerRecordMapper(), "abbreviations.txt");
    List<LapTimeRecord> lapTimeRecords = ModelLoader.loadModel(new LapTimeRecordMapper(), "start.log.txt", "end.log.txt");
    List<Racer> racers = ModelBuilder.buildModel(teamNameRecords, lapTimeRecords);


    Formatter formatter = new Formatter(new ColumnFactory());
    TableDescriptorFactory tableDescriptorFactory = new TableDescriptorFactory();


    String nameTable = "| No | Name               |\n" +
            "---------------------------\n" +
            "| 1  | Alexander Albon    |\n" +
            "| 2  | Antonio Giovinazzi |\n" +
            "| 3  | Carlos Sainz       |\n" +
            "| 4  | Charles Leclerc    |\n" +
            "| 5  | Daniel Ricciardo   |\n" +
            "| 6  | Daniil Kvyat       |\n" +
            "| 7  | George Russell     |\n" +
            "| 8  | Kevin Magnussen    |\n" +
            "| 9  | Kimi Räikkönen     |\n" +
            "| 10 | Lance Stroll       |\n" +
            "| 11 | Lando Norris       |\n" +
            "| 12 | Lewis Hamilton     |\n" +
            "| 13 | Max Verstappen     |\n" +
            "| 14 | Nico Hulkenberg    |\n" +
            "| 15 | Pierre Gasly       |\n" +
            "---------------------------\n" +
            "| 16 | Robert Kubica      |\n" +
            "| 17 | Romain Grosjean    |\n" +
            "| 18 | Sebastian Vettel   |\n" +
            "| 19 | Sergio Perez       |\n" +
            "| 20 | Valtteri Bottas    |";

    @Test
    void shouldVerifyNameTableOutput() {
        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.NAME);
        assertEquals(nameTable, formatter.format(descriptor, racers));
    }

    String bestLapTable = "| No | Name               | Team                      | Best Lap time |\n" +
            "-----------------------------------------------------------------------\n" +
            "| 1  | Valtteri Bottas    | MERCEDES                  | 01:25.093     |\n" +
            "| 2  | Lewis Hamilton     | MERCEDES                  | 01:25.099     |\n" +
            "| 3  | Charles Leclerc    | FERRARI                   | 01:25.172     |\n" +
            "| 4  | Max Verstappen     | RED BULL RACING HONDA     | 01:25.276     |\n" +
            "| 5  | Sebastian Vettel   | FERRARI                   | 01:25.787     |\n" +
            "| 6  | Pierre Gasly       | RED BULL RACING HONDA     | 01:26.038     |\n" +
            "| 7  | Lando Norris       | MCLAREN RENAULT           | 01:26.079     |\n" +
            "| 8  | Daniel Ricciardo   | RENAULT                   | 01:26.182     |\n" +
            "| 9  | Carlos Sainz       | MCLAREN RENAULT           | 01:26.203     |\n" +
            "| 10 | Alexander Albon    | SCUDERIA TORO ROSSO HONDA | 01:26.345     |\n" +
            "| 11 | Romain Grosjean    | HAAS FERRARI              | 01:26.347     |\n" +
            "| 12 | Nico Hulkenberg    | RENAULT                   | 01:26.386     |\n" +
            "| 13 | Antonio Giovinazzi | ALFA ROMEO RACING FERRARI | 01:26.449     |\n" +
            "| 14 | Kimi Räikkönen     | ALFA ROMEO RACING FERRARI | 01:26.546     |\n" +
            "| 15 | Sergio Perez       | RACING POINT BWT MERCEDES | 01:26.649     |\n" +
            "-----------------------------------------------------------------------\n" +
            "| 16 | Kevin Magnussen    | HAAS FERRARI              | 01:26.662     |\n" +
            "| 17 | Daniil Kvyat       | SCUDERIA TORO ROSSO HONDA | 01:26.721     |\n" +
            "| 18 | Lance Stroll       | RACING POINT BWT MERCEDES | 01:26.762     |\n" +
            "| 19 | George Russell     | WILLIAMS MERCEDES         | 01:27.789     |\n" +
            "| 20 | Robert Kubica      | WILLIAMS MERCEDES         | --:--.---     |";

    @Test
    void shouldVerifyBestLapTableOutput() {
        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.BEST_LAP);
        assertEquals(bestLapTable, formatter.format(descriptor, racers));
    }

    String lapCountTable = "| No | Name               | Team                      | Lap count |\n" +
            "-------------------------------------------------------------------\n" +
            "| 1  | Lewis Hamilton     | MERCEDES                  | 3         |\n" +
            "| 2  | Alexander Albon    | SCUDERIA TORO ROSSO HONDA | 3         |\n" +
            "| 3  | Nico Hulkenberg    | RENAULT                   | 3         |\n" +
            "| 4  | Max Verstappen     | RED BULL RACING HONDA     | 3         |\n" +
            "| 5  | Lando Norris       | MCLAREN RENAULT           | 3         |\n" +
            "| 6  | Charles Leclerc    | FERRARI                   | 3         |\n" +
            "| 7  | Valtteri Bottas    | MERCEDES                  | 3         |\n" +
            "| 8  | Sebastian Vettel   | FERRARI                   | 3         |\n" +
            "| 9  | Daniel Ricciardo   | RENAULT                   | 3         |\n" +
            "| 10 | Carlos Sainz       | MCLAREN RENAULT           | 2         |\n" +
            "| 11 | Romain Grosjean    | HAAS FERRARI              | 2         |\n" +
            "| 12 | Pierre Gasly       | RED BULL RACING HONDA     | 2         |\n" +
            "| 13 | Kimi Räikkönen     | ALFA ROMEO RACING FERRARI | 2         |\n" +
            "| 14 | Sergio Perez       | RACING POINT BWT MERCEDES | 2         |\n" +
            "| 15 | Antonio Giovinazzi | ALFA ROMEO RACING FERRARI | 2         |\n" +
            "-------------------------------------------------------------------\n" +
            "| 16 | George Russell     | WILLIAMS MERCEDES         | 1         |\n" +
            "| 17 | Kevin Magnussen    | HAAS FERRARI              | 1         |\n" +
            "| 18 | Daniil Kvyat       | SCUDERIA TORO ROSSO HONDA | 1         |\n" +
            "| 19 | Lance Stroll       | RACING POINT BWT MERCEDES | 1         |\n" +
            "| 20 | Robert Kubica      | WILLIAMS MERCEDES         | 0         |";

    @Test
    void shouldVerifyLapCountTableOutput() {
        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.LAP_COUNT);
        assertEquals(lapCountTable, formatter.format(descriptor, racers));
    }

    String avgLapTimeTable = "| No | Name               | Team                      | Avg.Time  |\n" +
            "-------------------------------------------------------------------\n" +
            "| 1  | Charles Leclerc    | FERRARI                   | 01:25.417 |\n" +
            "| 2  | Lewis Hamilton     | MERCEDES                  | 01:25.484 |\n" +
            "| 3  | Valtteri Bottas    | MERCEDES                  | 01:25.505 |\n" +
            "| 4  | Max Verstappen     | RED BULL RACING HONDA     | 01:25.608 |\n" +
            "| 5  | Sebastian Vettel   | FERRARI                   | 01:25.902 |\n" +
            "| 6  | Pierre Gasly       | RED BULL RACING HONDA     | 01:26.155 |\n" +
            "| 7  | Lando Norris       | MCLAREN RENAULT           | 01:26.229 |\n" +
            "| 8  | Daniel Ricciardo   | RENAULT                   | 01:26.297 |\n" +
            "| 9  | Carlos Sainz       | MCLAREN RENAULT           | 01:26.390 |\n" +
            "| 10 | Alexander Albon    | SCUDERIA TORO ROSSO HONDA | 01:26.410 |\n" +
            "| 11 | Nico Hulkenberg    | RENAULT                   | 01:26.450 |\n" +
            "| 12 | Antonio Giovinazzi | ALFA ROMEO RACING FERRARI | 01:26.484 |\n" +
            "| 13 | Romain Grosjean    | HAAS FERRARI              | 01:26.552 |\n" +
            "| 14 | Kimi Räikkönen     | ALFA ROMEO RACING FERRARI | 01:26.552 |\n" +
            "| 15 | Kevin Magnussen    | HAAS FERRARI              | 01:26.662 |\n" +
            "-------------------------------------------------------------------\n" +
            "| 16 | Daniil Kvyat       | SCUDERIA TORO ROSSO HONDA | 01:26.721 |\n" +
            "| 17 | Lance Stroll       | RACING POINT BWT MERCEDES | 01:26.762 |\n" +
            "| 18 | Sergio Perez       | RACING POINT BWT MERCEDES | 01:26.788 |\n" +
            "| 19 | George Russell     | WILLIAMS MERCEDES         | 01:27.789 |\n" +
            "| 20 | Robert Kubica      | WILLIAMS MERCEDES         | --:--.--- |";

    @Test
    void shouldVerifyAvgLapTimeTableOutput() {
        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.AVG_LAP_TIME);
        assertEquals(avgLapTimeTable, formatter.format(descriptor, racers));
    }
}
