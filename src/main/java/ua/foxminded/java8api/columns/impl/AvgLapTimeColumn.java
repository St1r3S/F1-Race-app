package ua.foxminded.java8api.columns.impl;

import ua.foxminded.java8api.columns.Column;
import ua.foxminded.java8api.misc.RacerUtility;
import ua.foxminded.java8api.model.Racer;

import java.util.Comparator;

public class AvgLapTimeColumn implements Column {
    @Override
    public String getTitle() {
        return "Avg.Time";
    }

    @Override
    public String getData(Racer racer) {
        return RacerUtility.durationToString.compose(RacerUtility.avgLapDuration).apply(racer);
    }

    @Override
    public Comparator<Racer> getComparator() {
        return Comparator.comparing(RacerUtility.avgLapDuration::apply);
    }
}
