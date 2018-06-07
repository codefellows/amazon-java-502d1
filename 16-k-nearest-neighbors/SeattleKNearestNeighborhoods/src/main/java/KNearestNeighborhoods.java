// CSV from Kaggle. AirBnB Seattle dataset.
// https://www.kaggle.com/airbnb/seattle/data

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KNearestNeighborhoods {
    // https://www.google.com/maps/@47.6494201,-122.3322363,14z
    public static MapPoint[] UNCLASSIFIED_POINTS = {
        new MapPoint("Code Fellows", 47.618306, -122.351721),
        new MapPoint("Interbay?", 47.651160, -122.379999)
    };

    public static void main(String[] args) {
        try {
            String csvPath = "/Users/moonmayor/Fellows/amazon-java-501d1/16-k-nearest-neighbors/SeattleKNearestNeighborhoods/src/main/resources/listings.csv";
            CSVReader reader = new CSVReader(new FileReader(csvPath));
            List<MapPoint> points = reader.readAll().stream()
            .skip(1) // skip over the CSV header row.
            .map(columns -> {
                String neighborhood = columns[36];
                String latitude = columns[45];
                String longitude = columns[46];
                return MapPoint.fromStrings(neighborhood, latitude, longitude);
            })
            .filter(bnb -> bnb != null)
            .collect(Collectors.toList());

            Set<String> neighborhoods =
                points.stream().map(pp -> pp.neighborhood).collect(Collectors.toSet());
            neighborhoods.forEach(System.out::println);
            System.out.println();

            for (MapPoint target : UNCLASSIFIED_POINTS) {
                String label = kNearestNeighbors(5, points, target);
                System.out.println("Neighborhood: " + label);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String kNearestNeighbors(int k, List<MapPoint> labels, MapPoint bnb) {
        return labels.stream()
        .map(p1 -> p1.distance(bnb))
        .sorted(Comparator.comparingDouble(Distance::getDistance))
        .limit(k)
        .map(dd -> dd.location.neighborhood)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .sorted((kv1,kv2) -> -1 * Long.compare(kv1.getValue(), kv2.getValue()))
        .limit(1)
        .collect(Collectors.toList()).get(0).getKey();
    }
}
