package ua.foxminded.java8api.parser;

import ua.foxminded.java8api.model.LapTimeRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class LapTimeRecordMapper implements Function<String, LapTimeRecord> {

    @Override
    public LapTimeRecord apply(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string cant be empty or null");
        }
        try {
            String abbr = s.substring(0, 3);
            String timerStr = s.substring(3);
            LocalDateTime time = LocalDateTime.parse(timerStr, DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS"));
            return new LapTimeRecord(abbr, time);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to parse " + s, e);
        }
    }

}
