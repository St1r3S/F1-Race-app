package ua.foxminded.java8api.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

    public static Stream<String> getStream(String fileName) {
        try {
            return Files.lines(getPath(fileName));
        } catch (IOException exc) {
            throw new RuntimeException("I/O Error", exc);
        }
    }

    private static Path getPath(String fileName) {
        URL resource = FileUtils.class.getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new NullPointerException("File not found!");
        }
        try {
            return Paths.get(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable to find file " + fileName, e);
        }
    }
}
