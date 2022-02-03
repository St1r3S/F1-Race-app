package ua.foxminded.java8api.columns.impl;

import ua.foxminded.java8api.model.Racer;
import ua.foxminded.java8api.columns.Column;

import java.util.Comparator;

public class NumColumn implements Column {
    private Integer counter = 0;

    @Override
    public String getTitle() {
        return "No";
    }

    @Override
    public String getData(Racer racer) {
        counter++;
        return counter.toString();
    }

    @Override
    public Comparator<Racer> getComparator() {
        throw new IllegalStateException("Not implemented");
    }
}
