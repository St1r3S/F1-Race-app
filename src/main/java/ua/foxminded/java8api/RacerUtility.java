package ua.foxminded.java8api;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.function.Function;

public class RacerUtility {

    private RacerUtility() {
    }

    public static final Function<Lap, Duration> lapDuration = (lap) -> {
        if (lap.getFinish() != null) {
            return Duration.between(lap.getStart(), lap.getFinish());
        } else {
            return ChronoUnit.FOREVER.getDuration();
        }
    };

    public static final Function<Racer, Duration> avgLapDuration = (racer) -> {
        Duration dur = lapDuration.apply(racer.getLaps().get(0));
        if (racer.getLaps().size() == 1) {
            return dur;
        }
        for (int i = 1; i < racer.getLaps().size(); i++) {
            if (lapDuration.apply(racer.getLaps().get(i)) == ChronoUnit.FOREVER.getDuration()) {
                continue;
            }
            dur = dur.plus(lapDuration.apply(racer.getLaps().get(i)));
        }
        dur = dur.dividedBy(racer.getLaps().size());
        return dur;
    };

    public static final Function<Racer, Lap> bestLap = (racer) -> racer.getLaps().stream()
            .sorted(Comparator.comparing(lapDuration::apply))
            .findFirst().get();

    public static final Function<Racer, String> name = (racer) -> racer.getRacerName();
}
