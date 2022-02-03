package ua.foxminded.java8api;

import ua.foxminded.java8api.columns.ColumnFactory;
import ua.foxminded.java8api.columns.ColumnType;
import ua.foxminded.java8api.tables.TableDescriptorFactory;
import ua.foxminded.java8api.tables.TableType;

import java.util.List;
import java.util.stream.Collectors;

public class Formatter {

    public String format(TableDescriptorFactory tableDescriptorFactory, List<ColumnType> columnTypes, ColumnFactory columnFactory, List<Racer> racers, TableType type) {


        StringBuilder result = new StringBuilder();
        racers = racers.stream().sorted(columnFactory.getColumn(tableDescriptorFactory.getTable(type).getDefaultSortColumnType()).getComparator()).collect(Collectors.toList());

        int maxNameLength = racers.stream()
                .map(racer -> racer.getRacerName().length())
                .sorted((o1, o2) -> o2 - o1)
                .findFirst().get();
        int maxTeamLength = 0;
        if (type == TableType.BestLapTable || type == TableType.LapCountTable || type == TableType.AvgLapTimeTable) {
            maxTeamLength = racers.stream()
                    .map(racer -> racer.getRacerCarName().length())
                    .sorted((o1, o2) -> o2 - o1)
                    .findFirst().get();
        }
        int i = 1;
        for (Racer racer : racers) {
            result.append(i++);
            if (i <= 10)
                result.append(" ");
            for (ColumnType columnType : columnTypes) {
                result.append(" |  ");
                if (columnType == ColumnType.NameColumn) {
                    result.append(columnFactory.getColumn(columnType).getData(racer)).append(repeatCharacter(maxNameLength - columnFactory.getColumn(columnType).getData(racer).length(), ' '));
                    continue;
                }
                if (columnType == ColumnType.TeamColumn) {
                    result.append(columnFactory.getColumn(columnType).getData(racer)).append(repeatCharacter(maxTeamLength - columnFactory.getColumn(columnType).getData(racer).length(), ' '));
                    continue;
                }

                result.append(columnFactory.getColumn(columnType).getData(racer));
            }
            result.append("\n");
            if (i == 16) {
                result.append(repeatCharacter(125, '-')).append("\n");
            }
        }

        return result.toString();
    }

    private static String repeatCharacter(int quantity, char character) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
