package ua.foxminded.java8api.columns;

import ua.foxminded.java8api.Racer;

import java.util.Comparator;

public class TeamColumn implements Column {
    @Override
    public String getTitle() {
        return ColumnType.TeamColumn.toString();
    }

    @Override
    public String getData(Racer racer) {
        return racer.getRacerCarName();
    }

    @Override
    public Comparator<Racer> getComparator() {
        return (o1, o2) -> o1.getRacerCarName().compareToIgnoreCase(o2.getRacerCarName());
    }
}
