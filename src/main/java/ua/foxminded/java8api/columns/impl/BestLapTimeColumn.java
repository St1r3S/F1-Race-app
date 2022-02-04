package ua.foxminded.java8api.columns.impl;

import ua.foxminded.java8api.columns.Column;
import ua.foxminded.java8api.model.Racer;

import java.util.Comparator;

import static ua.foxminded.java8api.misc.RacerUtility.*;

public class BestLapTimeColumn implements Column {
    @Override
    public String getTitle() {
        return "Best Lap time";
    }

    @Override
    public String getData(Racer racer) {
        return durationToString
                .compose(lapDuration)
                .compose(bestLap)
                .apply(racer);
    }

    @Override
    public Comparator<Racer> getComparator() {
        return Comparator.comparing(o -> lapDuration.apply(bestLap.apply(o)));
    }
}
