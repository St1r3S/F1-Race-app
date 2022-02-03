package ua.foxminded.java8api.columns.impl;

import ua.foxminded.java8api.model.Racer;
import ua.foxminded.java8api.misc.RacerUtility;
import ua.foxminded.java8api.columns.Column;

import java.util.Comparator;

public class NameColumn implements Column {
    @Override
    public String getTitle() {
        return "Name";
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
