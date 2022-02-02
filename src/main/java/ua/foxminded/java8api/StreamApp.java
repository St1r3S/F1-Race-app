package ua.foxminded.java8api;

import ua.foxminded.java8api.tables.TableType;

import java.util.ArrayList;
import java.util.List;

public class StreamApp {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        System.out.println(formatter.format(TableType.BestLapTable));

    }
}
