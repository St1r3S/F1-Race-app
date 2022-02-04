package ua.foxminded.java8api.parser;

import ua.foxminded.java8api.model.RacerRecord;

import java.util.function.Function;

public class TeamRacerRecordMapper implements Function<String, RacerRecord> {

    @Override
    public RacerRecord apply(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string cant be empty or null");
        }
        String[] parts = s.split("_", 3);
        if (parts.length != 3) {
            throw new IllegalArgumentException("Unable to parse " + s);
        }
        return new RacerRecord(parts[0], parts[1], parts[2]);
    }

}
