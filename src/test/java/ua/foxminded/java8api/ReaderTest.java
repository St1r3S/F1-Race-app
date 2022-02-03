package ua.foxminded.java8api;

import org.junit.jupiter.api.Test;
import ua.foxminded.java8api.parser.Reader;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    Reader reader = new Reader();

    String abbreviations = "CSM_Carlos Sainz_MCLAREN RENAULT\n" +
            "GRW_George Russell_WILLIAMS MERCEDES\n" +
            "LHM_Lewis Hamilton_MERCEDES\n" +
            "RGH_Romain Grosjean_HAAS FERRARI\n" +
            "AAS_Alexander Albon_SCUDERIA TORO ROSSO HONDA\n" +
            "PGR_Pierre Gasly_RED BULL RACING HONDA\n" +
            "NHR_Nico Hulkenberg_RENAULT\n" +
            "KMH_Kevin Magnussen_HAAS FERRARI\n" +
            "MVR_Max Verstappen_RED BULL RACING HONDA\n" +
            "RKW_Robert Kubica_WILLIAMS MERCEDES\n" +
            "LNM_Lando Norris_MCLAREN RENAULT\n" +
            "CLF_Charles Leclerc_FERRARI\n" +
            "VBM_Valtteri Bottas_MERCEDES\n" +
            "KRA_Kimi Räikkönen_ALFA ROMEO RACING FERRARI\n" +
            "SPR_Sergio Perez_RACING POINT BWT MERCEDES\n" +
            "AGA_Antonio Giovinazzi_ALFA ROMEO RACING FERRARI\n" +
            "SVF_Sebastian Vettel_FERRARI\n" +
            "DKS_Daniil Kvyat_SCUDERIA TORO ROSSO HONDA\n" +
            "DRR_Daniel Ricciardo_RENAULT\n" +
            "LSR_Lance Stroll_RACING POINT BWT MERCEDES\n";

    String endLogs = "VBM2019-07-12_12:25:08.224\n" +
            "VBM2019-07-12_12:28:56.396\n" +
            "VBM2019-07-12_12:33:41.785\n" +
            "LHM2019-07-12_12:16:12.657\n" +
            "LHM2019-07-12_12:19:20.052\n" +
            "LHM2019-07-12_12:24:51.732\n" +
            "NHR2019-07-12_12:17:30.931\n" +
            "NHR2019-07-12_12:19:57.706\n" +
            "NHR2019-07-12_12:22:55.693\n" +
            "DRR2019-07-12_12:22:13.056\n" +
            "DRR2019-07-12_12:26:45.686\n" +
            "DRR2019-07-12_12:29:26.432\n" +
            "MVR2019-07-12_12:26:31.131\n" +
            "MVR2019-07-12_12:29:17.209\n" +
            "MVR2019-07-12_12:33:06.325\n" +
            "PGR2019-07-12_12:15:32.671\n" +
            "PGR2019-07-12_12:19:54.279\n" +
            "AGA2019-07-12_12:08:51.987\n" +
            "AGA2019-07-12_12:10:55.855\n" +
            "KRA2019-07-12_12:26:41.599\n" +
            "KRA2019-07-12_12:32:24.372\n" +
            "CLF2019-07-12_12:27:28.068\n" +
            "CLF2019-07-12_12:32:47.980\n" +
            "CLF2019-07-12_12:36:23.893\n" +
            "SVF2019-07-12_12:16:01.977\n" +
            "SVF2019-07-12_12:20:06.423\n" +
            "SVF2019-07-12_12:23:12.762\n" +
            "GRW2019-07-12_12:28:00.792\n" +
            "DKS2019-07-12_12:07:35.607\n" +
            "AAS2019-07-12_12:22:56.732\n" +
            "AAS2019-07-12_12:26:12.201\n" +
            "AAS2019-07-12_12:29:06.327\n" +
            "CSM2019-07-12_12:27:58.645\n" +
            "CSM2019-07-12_12:30:26.054\n" +
            "LNM2019-07-12_12:20:50.640\n" +
            "LNM2019-07-12_12:26:26.523\n" +
            "LNM2019-07-12_12:29:47.539\n" +
            "SPR2019-07-12_12:18:21.464\n" +
            "SPR2019-07-12_12:20:38.421\n" +
            "LSR2019-07-12_12:08:48.316\n" +
            "KMH2019-07-12_12:11:10.953\n" +
            "RGH2019-07-12_12:30:54.699\n" +
            "RGH2019-07-12_12:34:35.360\n";

    String startLog = "VBM2019-07-12_12:23:42.474\n" +
            "VBM2019-07-12_12:27:30.724\n" +
            "VBM2019-07-12_12:32:16.692\n" +
            "LHM2019-07-12_12:14:47.144\n" +
            "LHM2019-07-12_12:17:54.212\n" +
            "LHM2019-07-12_12:23:26.633\n" +
            "NHR2019-07-12_12:16:04.363\n" +
            "NHR2019-07-12_12:18:31.309\n" +
            "NHR2019-07-12_12:21:29.307\n" +
            "DRR2019-07-12_12:20:46.628\n" +
            "DRR2019-07-12_12:25:19.403\n" +
            "DRR2019-07-12_12:28:00.250\n" +
            "MVR2019-07-12_12:25:05.431\n" +
            "MVR2019-07-12_12:27:51.361\n" +
            "MVR2019-07-12_12:31:41.049\n" +
            "PGR2019-07-12_12:14:06.398\n" +
            "PGR2019-07-12_12:18:28.241\n" +
            "PGR2019-07-12_12:23:15.913\n" +
            "AGA2019-07-12_12:07:25.538\n" +
            "AGA2019-07-12_12:09:29.336\n" +
            "KRA2019-07-12_12:25:15.041\n" +
            "KRA2019-07-12_12:30:57.826\n" +
            "CLF2019-07-12_12:26:02.535\n" +
            "CLF2019-07-12_12:31:22.434\n" +
            "CLF2019-07-12_12:34:58.721\n" +
            "SVF2019-07-12_12:14:36.079\n" +
            "SVF2019-07-12_12:18:40.400\n" +
            "SVF2019-07-12_12:21:46.975\n" +
            "GRW2019-07-12_12:26:33.003\n" +
            "RKW2019-07-12_12:06:39.457\n" +
            "DKS2019-07-12_12:06:08.886\n" +
            "AAS2019-07-12_12:21:30.250\n" +
            "AAS2019-07-12_12:24:45.798\n" +
            "AAS2019-07-12_12:27:39.982\n" +
            "CSM2019-07-12_12:26:32.442\n" +
            "CSM2019-07-12_12:28:59.476\n" +
            "LNM2019-07-12_12:19:24.561\n" +
            "LNM2019-07-12_12:25:00.138\n" +
            "LNM2019-07-12_12:28:21.315\n" +
            "SPR2019-07-12_12:16:54.815\n" +
            "SPR2019-07-12_12:19:11.493\n" +
            "LSR2019-07-12_12:07:21.554\n" +
            "KMH2019-07-12_12:09:44.291\n" +
            "RGH2019-07-12_12:29:28.352\n" +
            "RGH2019-07-12_12:33:08.603\n";

    @Test
    void shouldVerifyAbbreviationRead() {
        assertEquals(abbreviations, reader.getAbbreviations());
    }

    @Test
    void shouldVerifyEndLogRead() {
        assertEquals(endLogs, reader.getEndLog());
    }

    @Test
    void shouldVerifyStartLogRead() {
        assertEquals(startLog, reader.getStartLog());
    }
}
