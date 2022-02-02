package ua.foxminded.java8api.columns;

import ua.foxminded.java8api.Racer;
import ua.foxminded.java8api.RacerUtility;

import java.util.Comparator;

public class NameColumn implements Column {
    @Override
    public String getTitle() {
        return ColumnType.NameColumn.toString();
    }

    @Override
    public String getData(Racer racer) {
        return RacerUtility.name.apply(racer);
    }

    @Override
    public Comparator<Racer> getComparator() {
        return (o1, o2) -> RacerUtility.name.apply(o1).compareToIgnoreCase(RacerUtility.name.apply(o2));
    }
}
