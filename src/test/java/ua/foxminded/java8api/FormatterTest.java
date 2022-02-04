package ua.foxminded.java8api;

import org.junit.jupiter.api.Test;
import ua.foxminded.java8api.formatter.Formatter;
import ua.foxminded.java8api.model.Racer;
import ua.foxminded.java8api.parser.Parser;
import ua.foxminded.java8api.tables.TableDescriptor;
import ua.foxminded.java8api.tables.TableDescriptorFactory;
import ua.foxminded.java8api.tables.TableType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {



//    Formatter formatter = new Formatter();
//    Parser parser = new Parser();
//    TableDescriptorFactory tableDescriptorFactory = new TableDescriptorFactory();
//
//    List<Racer> racers = parser.parseRacer(parser.parseAbbreviations(), parser.parseLaps());
//
//
//    String nameTable = "1  |  Alexander Albon   \n" +
//            "2  |  Antonio Giovinazzi\n" +
//            "3  |  Carlos Sainz      \n" +
//            "4  |  Charles Leclerc   \n" +
//            "5  |  Daniel Ricciardo  \n" +
//            "6  |  Daniil Kvyat      \n" +
//            "7  |  George Russell    \n" +
//            "8  |  Kevin Magnussen   \n" +
//            "9  |  Kimi Räikkönen    \n" +
//            "10 |  Lance Stroll      \n" +
//            "11 |  Lando Norris      \n" +
//            "12 |  Lewis Hamilton    \n" +
//            "13 |  Max Verstappen    \n" +
//            "14 |  Nico Hulkenberg   \n" +
//            "15 |  Pierre Gasly      \n" +
//            "-----------------------------------------------------------------------------------------------------------------------------\n" +
//            "16 |  Robert Kubica     \n" +
//            "17 |  Romain Grosjean   \n" +
//            "18 |  Sebastian Vettel  \n" +
//            "19 |  Sergio Perez      \n" +
//            "20 |  Valtteri Bottas   \n";
//
//    @Test
//    void shouldVerifyNameTableOutput() {
//        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.NAME);
//        assertEquals(nameTable, formatter.format(descriptor, racers));
//    }
//
//    String bestLapTable = "1  |  Valtteri Bottas    |  MERCEDES                  |  Lap(start=2019-07-12T12:32:16.692, finish=2019-07-12T12:33:41.785)\n" +
//            "2  |  Lewis Hamilton     |  MERCEDES                  |  Lap(start=2019-07-12T12:23:26.633, finish=2019-07-12T12:24:51.732)\n" +
//            "3  |  Charles Leclerc    |  FERRARI                   |  Lap(start=2019-07-12T12:34:58.721, finish=2019-07-12T12:36:23.893)\n" +
//            "4  |  Max Verstappen     |  RED BULL RACING HONDA     |  Lap(start=2019-07-12T12:31:41.049, finish=2019-07-12T12:33:06.325)\n" +
//            "5  |  Sebastian Vettel   |  FERRARI                   |  Lap(start=2019-07-12T12:21:46.975, finish=2019-07-12T12:23:12.762)\n" +
//            "6  |  Pierre Gasly       |  RED BULL RACING HONDA     |  Lap(start=2019-07-12T12:18:28.241, finish=2019-07-12T12:19:54.279)\n" +
//            "7  |  Lando Norris       |  MCLAREN RENAULT           |  Lap(start=2019-07-12T12:19:24.561, finish=2019-07-12T12:20:50.640)\n" +
//            "8  |  Daniel Ricciardo   |  RENAULT                   |  Lap(start=2019-07-12T12:28:00.250, finish=2019-07-12T12:29:26.432)\n" +
//            "9  |  Carlos Sainz       |  MCLAREN RENAULT           |  Lap(start=2019-07-12T12:26:32.442, finish=2019-07-12T12:27:58.645)\n" +
//            "10 |  Alexander Albon    |  SCUDERIA TORO ROSSO HONDA |  Lap(start=2019-07-12T12:27:39.982, finish=2019-07-12T12:29:06.327)\n" +
//            "11 |  Romain Grosjean    |  HAAS FERRARI              |  Lap(start=2019-07-12T12:29:28.352, finish=2019-07-12T12:30:54.699)\n" +
//            "12 |  Nico Hulkenberg    |  RENAULT                   |  Lap(start=2019-07-12T12:21:29.307, finish=2019-07-12T12:22:55.693)\n" +
//            "13 |  Antonio Giovinazzi |  ALFA ROMEO RACING FERRARI |  Lap(start=2019-07-12T12:07:25.538, finish=2019-07-12T12:08:51.987)\n" +
//            "14 |  Kimi Räikkönen     |  ALFA ROMEO RACING FERRARI |  Lap(start=2019-07-12T12:30:57.826, finish=2019-07-12T12:32:24.372)\n" +
//            "15 |  Sergio Perez       |  RACING POINT BWT MERCEDES |  Lap(start=2019-07-12T12:16:54.815, finish=2019-07-12T12:18:21.464)\n" +
//            "-----------------------------------------------------------------------------------------------------------------------------\n" +
//            "16 |  Kevin Magnussen    |  HAAS FERRARI              |  Lap(start=2019-07-12T12:09:44.291, finish=2019-07-12T12:11:10.953)\n" +
//            "17 |  Daniil Kvyat       |  SCUDERIA TORO ROSSO HONDA |  Lap(start=2019-07-12T12:06:08.886, finish=2019-07-12T12:07:35.607)\n" +
//            "18 |  Lance Stroll       |  RACING POINT BWT MERCEDES |  Lap(start=2019-07-12T12:07:21.554, finish=2019-07-12T12:08:48.316)\n" +
//            "19 |  George Russell     |  WILLIAMS MERCEDES         |  Lap(start=2019-07-12T12:26:33.003, finish=2019-07-12T12:28:00.792)\n" +
//            "20 |  Robert Kubica      |  WILLIAMS MERCEDES         |  Lap(start=2019-07-12T12:06:39.457, finish=null)\n";
//
//    @Test
//    void shouldVerifyBestLapTableOutput() {
//        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.BESTLAPTABLE);
//        assertEquals(bestLapTable, formatter.format(descriptor, racers));
//    }
//
//    String lapCountTable = "1  |  Lewis Hamilton     |  MERCEDES                  |  3\n" +
//            "2  |  Alexander Albon    |  SCUDERIA TORO ROSSO HONDA |  3\n" +
//            "3  |  Pierre Gasly       |  RED BULL RACING HONDA     |  3\n" +
//            "4  |  Nico Hulkenberg    |  RENAULT                   |  3\n" +
//            "5  |  Max Verstappen     |  RED BULL RACING HONDA     |  3\n" +
//            "6  |  Lando Norris       |  MCLAREN RENAULT           |  3\n" +
//            "7  |  Charles Leclerc    |  FERRARI                   |  3\n" +
//            "8  |  Valtteri Bottas    |  MERCEDES                  |  3\n" +
//            "9  |  Sebastian Vettel   |  FERRARI                   |  3\n" +
//            "10 |  Daniel Ricciardo   |  RENAULT                   |  3\n" +
//            "11 |  Carlos Sainz       |  MCLAREN RENAULT           |  2\n" +
//            "12 |  Romain Grosjean    |  HAAS FERRARI              |  2\n" +
//            "13 |  Kimi Räikkönen     |  ALFA ROMEO RACING FERRARI |  2\n" +
//            "14 |  Sergio Perez       |  RACING POINT BWT MERCEDES |  2\n" +
//            "15 |  Antonio Giovinazzi |  ALFA ROMEO RACING FERRARI |  2\n" +
//            "-----------------------------------------------------------------------------------------------------------------------------\n" +
//            "16 |  George Russell     |  WILLIAMS MERCEDES         |  1\n" +
//            "17 |  Kevin Magnussen    |  HAAS FERRARI              |  1\n" +
//            "18 |  Robert Kubica      |  WILLIAMS MERCEDES         |  1\n" +
//            "19 |  Daniil Kvyat       |  SCUDERIA TORO ROSSO HONDA |  1\n" +
//            "20 |  Lance Stroll       |  RACING POINT BWT MERCEDES |  1\n";
//
//    @Test
//    void shouldVerifyLapCountTableOutput() {
//        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.LAP_COUNT);
//        assertEquals(lapCountTable, formatter.format(descriptor, racers));
//    }
//
//    String avgLapTimeTable = "1  |  Pierre Gasly       |  RED BULL RACING HONDA     |  PT57.437S\n" +
//            "2  |  Charles Leclerc    |  FERRARI                   |  PT1M25.417S\n" +
//            "3  |  Lewis Hamilton     |  MERCEDES                  |  PT1M25.484S\n" +
//            "4  |  Valtteri Bottas    |  MERCEDES                  |  PT1M25.505S\n" +
//            "5  |  Max Verstappen     |  RED BULL RACING HONDA     |  PT1M25.608S\n" +
//            "6  |  Sebastian Vettel   |  FERRARI                   |  PT1M25.902666666S\n" +
//            "7  |  Lando Norris       |  MCLAREN RENAULT           |  PT1M26.229333333S\n" +
//            "8  |  Daniel Ricciardo   |  RENAULT                   |  PT1M26.297666666S\n" +
//            "9  |  Carlos Sainz       |  MCLAREN RENAULT           |  PT1M26.3905S\n" +
//            "10 |  Alexander Albon    |  SCUDERIA TORO ROSSO HONDA |  PT1M26.41S\n" +
//            "11 |  Nico Hulkenberg    |  RENAULT                   |  PT1M26.450333333S\n" +
//            "12 |  Antonio Giovinazzi |  ALFA ROMEO RACING FERRARI |  PT1M26.484S\n" +
//            "13 |  Romain Grosjean    |  HAAS FERRARI              |  PT1M26.552S\n" +
//            "14 |  Kimi Räikkönen     |  ALFA ROMEO RACING FERRARI |  PT1M26.552S\n" +
//            "15 |  Kevin Magnussen    |  HAAS FERRARI              |  PT1M26.662S\n" +
//            "-----------------------------------------------------------------------------------------------------------------------------\n" +
//            "16 |  Daniil Kvyat       |  SCUDERIA TORO ROSSO HONDA |  PT1M26.721S\n" +
//            "17 |  Lance Stroll       |  RACING POINT BWT MERCEDES |  PT1M26.762S\n" +
//            "18 |  Sergio Perez       |  RACING POINT BWT MERCEDES |  PT1M26.7885S\n" +
//            "19 |  George Russell     |  WILLIAMS MERCEDES         |  PT1M27.789S\n" +
//            "20 |  Robert Kubica      |  WILLIAMS MERCEDES         |  PT2562047788015215H30M7.999999999S\n";
//
//    @Test
//    void shouldVerifyAvgLapTimeTableOutput() {
//        TableDescriptor descriptor = tableDescriptorFactory.getTable(TableType.AVG_LAP_TIME);
//        assertEquals(avgLapTimeTable, formatter.format(descriptor, racers));
//    }
}
