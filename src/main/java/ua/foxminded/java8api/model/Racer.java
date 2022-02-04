package ua.foxminded.java8api.model;

import lombok.Data;

import java.util.List;

@Data
public class Racer {
    private final String racerAbbreviation;
    private final String racerName;
    private final String racerCarName;
    private final List<Lap> laps;
}
