package ua.foxminded.java8api.columns.impl;

import ua.foxminded.java8api.model.Racer;
import ua.foxminded.java8api.columns.Column;

import java.util.Comparator;

public class TeamColumn implements Column {
    @Override
    public String getTitle() {
        return "Team";
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
