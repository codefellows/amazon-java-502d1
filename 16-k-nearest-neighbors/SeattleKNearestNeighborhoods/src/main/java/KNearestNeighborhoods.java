// CSV from Kaggle. AirBnB Seattle dataset.
// https://www.kaggle.com/airbnb/seattle/data

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KNearestNeighborhoods {
    // https://www.google.com/maps/@47.6494201,-122.3322363,14z
    public static MapPoint FREMONT_CENTER = new MapPoint("Fremont", 47.658178, -122.360320);
    public static MapPoint WALLINGFORD_CENTER = new MapPoint("Wallingford", 47.661966, -122.330176);
    public static MapPoint AMBIGUOUS_CENTER = new MapPoint("Unknown", 47.657919,-122.342450);
    public static MapPoint BALLARD = new MapPoint("Ballard", 47.670209, -122.387887);
    public static MapPoint BEACON_HILL = new MapPoint("Beacon Hill", 47.577061, -122.310106);
    public static MapPoint WHITE_CENTER = new MapPoint("White Center", 47.510911, -122.355677);
    public static MapPoint[] ALL_POINTS = {
        FREMONT_CENTER,
        WALLINGFORD_CENTER,
        AMBIGUOUS_CENTER,
        BALLARD,
        BEACON_HILL,
        WHITE_CENTER,
    };

    public static void main(String[] args) {
        try {
            String csvPath = "/Users/moonmayor/Fellows/amazon-java-501d1/16-k-nearest-neighbors/SeattleKNearestNeighborhoods/src/main/resources/listings.csv";
            CSVReader reader = new CSVReader(new FileReader(csvPath));
            List<MapPoint> points = reader.readAll().stream()
            .skip(1)
            .map(columns -> {
                //String neighborhood = columns[10];
                String neighborhood = columns[36];
                String latitude = columns[45];
                String longitude = columns[46];
                return MapPoint.fromStrings(neighborhood, latitude, longitude);
            })
            .filter(bnb -> bnb != null)
            .collect(Collectors.toList());

            for (MapPoint target : ALL_POINTS) {
                String label = kNearestNeighbords(5, points, target);
                System.out.println(label);
            }
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
        .map(dd -> dd.location.neighborhood)
        .collect(Collectors.toList());
        System.out.println(votes);

        // determine majority
        Map<String, Integer> tally = new HashMap<>();
        votes.forEach(vote -> {
            if (!tally.containsKey(vote)) {
               tally.put(vote, 0);
            }
            tally.put(vote, tally.get(vote) + 1);
        });

        String winner = votes.get(0);
        int most = 0;
        for (Map.Entry<String, Integer> entry : tally.entrySet()) {
            if (entry.getValue() > most) {
                winner = entry.getKey();
                most = entry.getValue();
            }
        }

        return winner;
    }
}
