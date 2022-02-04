package ua.foxminded.java8api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelBuilder {

    public static List<Racer> buildModel(List<RacerRecord> teamNameRecords, List<LapTimeRecord> lapTimeRecords) {
        Map<String, List<LapTimeRecord>> lapTimeRecordsMap = lapTimeRecords.stream()
                .collect(Collectors.groupingBy(LapTimeRecord::getRacerAbbreviation, Collectors.toList()));

        return teamNameRecords.stream()
                .map(r -> buildRacer(r, lapTimeRecordsMap.get(r.getRacerAbbreviation())))
                .collect(Collectors.toList());
    }

    private static Racer buildRacer(RacerRecord teamAndName, List<LapTimeRecord> lapsTimeRecords) {
        List<LocalDateTime> sortedTime = lapsTimeRecords.stream().sorted(Comparator.comparing(LapTimeRecord::getRecordedAt))
                .map(LapTimeRecord::getRecordedAt).collect(Collectors.toList());
        List<Lap> laps = new ArrayList<>();
        LocalDateTime start = null;
        for (LocalDateTime time : sortedTime) {
            if (start == null) {
                start = time;
            } else {
                laps.add(new Lap(start, time));
                start = null;
            }
        }
        return new Racer(teamAndName.getRacerName(), teamAndName.getRacerCarName(), laps);
    }

}
