package ua.foxminded.java8api.columns;

import ua.foxminded.java8api.model.Racer;

import java.util.Comparator;

public interface Column {
    String getTitle();

    String getData(Racer racer);

    Comparator<Racer> getComparator();

}
