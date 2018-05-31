public class MapPoint {
    public String neighborhood;
    public double latitude;
    public double longitude;

    public static MapPoint fromStrings(String description, String latt, String longg) {
        double latitude = Double.parseDouble(latt);
        double longitude = Double.parseDouble(longg);
        if (Double.isNaN(latitude) || Double.isNaN(longitude)) {
            return null;
        }
        return new MapPoint(description, latitude, longitude);
    }

    public MapPoint(String neighborhood, double latt, double longg) {
        this.neighborhood = neighborhood;
        this.latitude = latt;
        this.longitude = longg;
    }

    public Distance distance(MapPoint other) {
        double deltaLat = other.latitude - this.latitude;
        double deltaLong = other.longitude - this.longitude;
        double distance = Math.sqrt(deltaLat * deltaLat + deltaLong * deltaLong);
        return new Distance(distance, this);
    }

    public String toString() {
        return this.neighborhood;
    }
}
