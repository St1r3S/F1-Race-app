package ua.foxminded.java8api.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Lap {
    private final LocalDateTime start;
    private final LocalDateTime finish;
}
