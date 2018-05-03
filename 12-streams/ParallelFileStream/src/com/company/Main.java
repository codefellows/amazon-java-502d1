package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // download the CSV from kaggle at:
        // https://www.kaggle.com/edumucelli/spotifys-worldwide-daily-song-ranking
        Stream<String> stream = Files.lines(Paths.get("/Users/moonmayor/Fellows/amazon-java-501d1/12-streams/ParallelFileStream/src/com/company/data.csv"));

        Map<String, Integer> artistCount = new HashMap<>();
        stream
                .parallel()
                .map(String::toLowerCase)
                .map(line -> line.split(","))
                .filter(cells -> cells.length >= 3)
                .map(cells -> cells[2]) // artistName
                .forEach(artist -> {
                    int count = artistCount.getOrDefault(artist, 0);
                    artistCount.put(artist, count + 1);
                });

        int max = artistCount.entrySet().stream()
                .map(entry -> entry.getValue())
                .max(Integer::compare)
                .get();

        List<String> mostPopularArtists = artistCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= max)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        mostPopularArtists.forEach(System.out::println);
    }
}
