// CSV from Kaggle. AirBnB Seattle dataset.
// https://www.kaggle.com/airbnb/seattle/data

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KNearestNeighborhoods {
    // https://www.google.com/maps/@47.6494201,-122.3322363,14z
    public static MapPoint FREMONT_CENTER = new MapPoint("Fremont", 47.658178, -122.360320);
    public static MapPoint WALLINGFORD_CENTER = new MapPoint("Wallingford", 47.661966, -122.330176);
    public static MapPoint AMBIGUOUS_CENTER = new MapPoint("Unknown", 47.657919,-122.342450);

    public static void main(String[] args) {
        try {
            String csvPath = "/Users/moonmayor/Fellows/amazon-java-501d1/16-k-nearest-neighbors/SeattleKNearestNeighborhoods/src/main/resources/listings.csv";
            CSVReader reader = new CSVReader(new FileReader(csvPath));
            List<MapPoint> points = reader.readAll().stream()
            .skip(1)
            .map(cols -> {
                System.out.println(cols);
                return cols;
            })
            .map(columns -> {
                //String neighborhood = columns[10];
                String neighborhood = columns[36];
                String latitude = columns[45];
                String longitude = columns[46];

                System.out.println("Neighborhood: " + neighborhood);
                System.out.println("Latitude: " + latitude);
                System.out.println("Longitude: " + longitude);
                System.out.println();
                return MapPoint.fromStrings(neighborhood, latitude, longitude);
            })
            .filter(bnb -> bnb != null)
            .filter(bnb -> bnb.isFremont() || bnb.isWallingford())
            .collect(Collectors.toList());

            System.out.println("points: " + points);
            System.out.println("Total points: " + points.size());
            System.out.println();

            String label1 = kNearestNeighbords(3, points, FREMONT_CENTER);
            System.out.println(label1);
            String label2 = kNearestNeighbords(3, points, WALLINGFORD_CENTER);
            System.out.println(label2);
            String label3 = kNearestNeighbords(3, points, AMBIGUOUS_CENTER);
            System.out.println(label3);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String kNearestNeighbords(int k, List<MapPoint> labels, MapPoint bnb) {
        List<String> votes = labels.stream()
        .map(p1 -> p1.distance(bnb))
        .sorted((d1, d2) -> {
            if (d1.distance < d2.distance) {
                return -1;
            } else if (d1.distance > d2.distance) {
                return 1;
            }
            return 0;
        })
        .limit(k)
        .map(dd -> dd.location.neighborhood())
        .collect(Collectors.toList());
        System.out.println(votes);

        return votes.get(0);
    }
}
