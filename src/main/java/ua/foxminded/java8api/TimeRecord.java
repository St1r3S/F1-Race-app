package ua.foxminded.java8api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeRecord {
    private final String racerAbbreviation;
    private final LocalDateTime recordedAt;
}
