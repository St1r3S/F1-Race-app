package ua.foxminded.java8api;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public String getAbbreviations() {
        return readContent("src/main/resources/abbreviations.txt");
    }

    public String getEndLog() {
        return readContent("src/main/resources/end.log.txt");
    }

    public String getStartLog() {
        return readContent("src/main/resources/start.log.txt");
    }

    private String readContent(String path) {

        StringBuilder fileContent = new StringBuilder();
        try (FileReader fileReader = new FileReader(path)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent.toString();
    }
}
