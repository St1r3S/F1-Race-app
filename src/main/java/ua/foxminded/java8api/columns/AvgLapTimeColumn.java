package ua.foxminded.java8api.columns;

import ua.foxminded.java8api.Racer;
import ua.foxminded.java8api.RacerUtility;

import java.util.Comparator;

public class AvgLapTimeColumn implements Column {
    @Override
    public String getTitle() {
        return ColumnType.AvgLapTimeColumn.toString();
    }

    @Override
    public String getData(Racer racer) {
        return RacerUtility.avgLapDuration.apply(racer).toString();
    }

    @Override
    public Comparator<Racer> getComparator() {
        return Comparator.comparing(RacerUtility.avgLapDuration::apply);
    }
}
