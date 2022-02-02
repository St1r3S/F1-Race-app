package ua.foxminded.java8api.columns;

import ua.foxminded.java8api.Racer;
import ua.foxminded.java8api.RacerUtility;

import java.util.Comparator;

public class LapCountColumn implements Column {
    @Override
    public String getTitle() {
        return ColumnType.LapCountColumn.toString();
    }


    @Override
    public String getData(Racer racer) {
        return String.valueOf(racer.getLaps().size());
    }

    @Override
    public Comparator<Racer> getComparator() {
        return (o1, o2) -> o2.getLaps().size() - o1.getLaps().size();
    }
}
