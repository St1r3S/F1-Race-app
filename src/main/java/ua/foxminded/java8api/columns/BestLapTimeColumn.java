package ua.foxminded.java8api.columns;

import ua.foxminded.java8api.Racer;
import ua.foxminded.java8api.RacerUtility;

import java.util.Comparator;

public class BestLapTimeColumn implements Column {
    @Override
    public String getTitle() {
        return ColumnType.BestLapTimeColumn.toString();
    }

    @Override
    public String getData(Racer racer) {
        return RacerUtility.bestLap.apply(racer).toString();
    }

    @Override
    public Comparator<Racer> getComparator() {
        return Comparator.comparing(o -> RacerUtility.lapDuration.apply(RacerUtility.bestLap.apply(o)));
    }
}
