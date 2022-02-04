package ua.foxminded.java8api.parser;

import ua.foxminded.java8api.model.Lap;
import ua.foxminded.java8api.model.Racer;
import ua.foxminded.java8api.model.RacerRecord;
import ua.foxminded.java8api.model.TimeRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parser {

    public List<RacerRecord> parseAbbreviations() {
        String rawRacers = new Reader().getAbbreviations();
        List<RacerRecord> racerRecords = new ArrayList<>();
        String[] racerRow = rawRacers.split("\n");
        for (String rowPart : racerRow) {
            String[] filler = rowPart.split("_");
            racerRecords.add(new RacerRecord(filler[0], filler[1], filler[2]));
        }
        return racerRecords;
    }

    public List<Racer> parseRacer(List<RacerRecord> racerRecords, Map<String, List<Lap>> lapsAndRacersAbbreviations) {
        List<Racer> racers = new ArrayList<>();

        for (RacerRecord racerRecord : racerRecords) {
            racers.add(new Racer(racerRecord.getRacerAbbreviation(),
                    racerRecord.getRacerName(),
                    racerRecord.getRacerCarName(),
                    lapsAndRacersAbbreviations.get(racerRecord.getRacerAbbreviation())));
        }
        return racers;
    }

    private List<TimeRecord> parseStartLog() {
        String[] rawLogs = new Reader().getStartLog().split("\n");
        return parseLogs(rawLogs);
    }

    private List<TimeRecord> parseEndLog() {
        String[] rawLogs = new Reader().getEndLog().split("\n");
        return parseLogs(rawLogs);
    }

    public Map<String, List<Lap>> parseLaps() {

        List<TimeRecord> startRecords = parseStartLog();
        List<TimeRecord> endRecords = parseEndLog();

        Map<String, List<Lap>> lapsAndRacersAbbreviations = new HashMap<>();

        parseAbbreviations().stream()
                .map(RacerRecord::getRacerAbbreviation)
                .forEach(abbreviation -> {
                    List<Lap> laps = new ArrayList<>();
                    List<LocalDateTime> startLapsList = startRecords.stream()
                            .filter(start -> start.getRacerAbbreviation().equals(abbreviation))
                            .map(TimeRecord::getRecordedAt)
                            .collect(Collectors.toList());

                    List<LocalDateTime> endLapsList = endRecords.stream()
                            .filter(start -> start.getRacerAbbreviation().equals(abbreviation))
                            .map(TimeRecord::getRecordedAt)
                            .collect(Collectors.toList());

                    for (int i = 0; i < startLapsList.size(); i++) {
                        if (startLapsList.size() != endLapsList.size() && i + 1 == startLapsList.size()) {
                            laps.add(new Lap(startLapsList.get(i), null));
                        } else {
                            laps.add(new Lap(startLapsList.get(i), endLapsList.get(i)));
                        }
                    }
                    lapsAndRacersAbbreviations.put(abbreviation, laps);
                });
        return lapsAndRacersAbbreviations;
    }

    private List<TimeRecord> parseLogs(String[] logs) {
        List<TimeRecord> raceLogs = new ArrayList<>();
        LocalDateTime dateTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'_'HH:mm:ss.SSS");

        StringBuilder abbreviation = new StringBuilder();
        char[] chars;

        for (String log : logs) {
            chars = log.toCharArray();
            for (char aChar : chars) {
                if (Character.isDigit(aChar)) {
                    break;
                }
                abbreviation.append(aChar);
            }
            dateTime = LocalDateTime.parse(log.substring(3), formatter);
            raceLogs.add(new TimeRecord(abbreviation.toString(), dateTime));
            abbreviation.setLength(0);
        }
        return raceLogs;
    }
}
