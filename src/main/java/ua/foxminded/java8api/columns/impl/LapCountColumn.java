package ua.foxminded.java8api.columns.impl;

import ua.foxminded.java8api.model.Racer;
import ua.foxminded.java8api.columns.Column;

import java.util.Comparator;

public class LapCountColumn implements Column {
    @Override
    public String getTitle() {
        return "Lap count";
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
