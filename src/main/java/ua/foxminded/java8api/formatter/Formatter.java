package ua.foxminded.java8api.formatter;

import ua.foxminded.java8api.columns.Column;
import ua.foxminded.java8api.columns.ColumnFactory;
import ua.foxminded.java8api.model.Racer;
import ua.foxminded.java8api.tables.TableDescriptor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Formatter {

    private static final int DIVIDER = 15;

    private final ColumnFactory columnFactory;

    public Formatter(ColumnFactory columnFactory) {
        this.columnFactory = columnFactory;
    }

    public String format(TableDescriptor descriptor, List<Racer> racers) {

        List<Column> columns = descriptor.getColumns()
                .stream()
                .map(columnFactory::getColumn)
                .collect(toList());

        Column sortingColumn = columnFactory.getColumn(descriptor.getDefaultSortColumnType());

        List<String> headers = columns.stream().map(Column::getTitle).collect(toList());

        List<Integer> columnWidths = headers.stream().map(String::length).collect(toList());

        List<List<String>> cells = racers.stream()
                .sorted(sortingColumn.getComparator())
                .map(racer -> mapCells(racer, columns))
                .peek(row -> updateWidths(columnWidths, row))
                .collect(toList());

        String rowTemplate = columnWidths.stream()
                .map(w -> "%-" + w + "s")
                .collect(joining(" | ", "| ", " |"));

        String headerRow = String.format(
                rowTemplate,
                headers.toArray());

        String divideLine = lineOfChars(headerRow.length());
        return Stream.concat(
                        Stream.of(
                                headerRow,
                                divideLine
                        ),
                        tableBody(cells, rowTemplate)
                )
                .collect(Collectors.joining("\n"));
    }

    private Stream<String> tableBody(List<List<String>> cells, String rowTemplate) {
        AtomicInteger count = new AtomicInteger(0);

        return cells.stream()
                .map(row -> String.format(rowTemplate, row.toArray()))
                .map(row -> {
                    if (count.incrementAndGet() == DIVIDER) {
                        return row + "\n" + lineOfChars(row.length());
                    } else {
                        return row;
                    }
                });
    }

    private String lineOfChars(int length) {
        return new String(new char[length]).replace('\0', '-');
    }

    private void updateWidths(List<Integer> columnWidths, List<String> row) {
        for (int i = 0; i < columnWidths.size(); i++) {
            int cellWidth = row.get(i).length();
            if (columnWidths.get(i) < cellWidth) {
                columnWidths.set(i, cellWidth);
            }
        }
    }

    private List<String> mapCells(Racer racer, List<Column> columns) {
        return columns.stream().map(column -> column.getData(racer)).collect(toList());
    }
}
