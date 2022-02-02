package ua.foxminded.java8api;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    Parser parser = new Parser();
    List<RacerRecord> racerRecords = new ArrayList<>(Arrays.asList(new RacerRecord("CSM", "Carlos Sainz", "MCLAREN RENAULT")));
    Map<String, List<Lap>> lapsAndRacersAbbreviations = new HashMap<String, List<Lap>>() {{
        put("CSM", new LinkedList<>(Arrays.asList(
                new Lap(LocalDateTime.of(2019, 07, 12, 12, 26, 32, 442000000),
                        LocalDateTime.of(2019, 07, 12, 12, 27, 58, 645000000)),
                new Lap(LocalDateTime.of(2019, 07, 12, 12, 28, 59, 476000000),
                        LocalDateTime.of(2019, 07, 12, 12, 30, 26, 54000000))
        )));
    }};

    @Test
    void shouldVerifyParseRacer() {
        assertEquals(new Racer(racerRecords.get(0).getRacerAbbreviation(),
                        racerRecords.get(0).getRacerName(),
                        racerRecords.get(0).getRacerCarName(),
                        lapsAndRacersAbbreviations.get("CSM")),
                parser.parseRacer(parser.parseAbbreviations(), parser.parseLaps()).get(0));
    }

    @Test
    void shouldVerifyParseAbbreviation() {
        assertEquals(racerRecords.get(0), parser.parseAbbreviations().get(0));
    }

    @Test
    void shouldVerifyParseLaps() {
        assertEquals(lapsAndRacersAbbreviations.get("CSM"), parser.parseLaps().get("CSM"));
    }
}
