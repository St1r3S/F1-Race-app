package ua.foxminded.java8api;

import lombok.Data;

import java.util.List;

@Data
public class Racer {
    private final String racerAbbreviation;
    private final String racerName;
    private final String racerCarName;
    private final List<Lap> laps;
}
