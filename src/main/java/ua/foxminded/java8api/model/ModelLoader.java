package ua.foxminded.java8api.model;

import ua.foxminded.java8api.parser.FileUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModelLoader {
    public static <T> List<T> loadModel(Function<String, T> mapper, String... fileNames) {
        return Arrays.stream(fileNames).flatMap(FileUtils::getStream).map(mapper)
                .collect(Collectors.toList());
    }
}
