package ua.foxminded.java8api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Lap {
    private final LocalDateTime start;
    private final LocalDateTime finish;
}
