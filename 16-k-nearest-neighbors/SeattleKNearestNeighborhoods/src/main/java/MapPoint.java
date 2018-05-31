public class MapPoint {
    public String description;
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

    public MapPoint(String description, double latt, double longg) {
        this.description = description;
        this.latitude = latt;
        this.longitude = longg;
    }

    public String neighborhood() {
        if (isWallingford() && isFremont()) {
            return "Wallingford/Fremont";
        } else if (isWallingford()) {
            return "Wallingford";
        } else if (isFremont()) {
            return "Fremont";
        }
        return "Unknown";
    }

    public boolean isWallingford() {
        return this.description.contains("Wallingford");
    }

    public boolean isFremont() {
        return this.description.contains("Fremont");
    }

    public Distance distance(MapPoint other) {
        double deltaLat = other.latitude - this.latitude;
        double deltaLong = other.longitude - this.longitude;
        double distance = Math.sqrt(deltaLat * deltaLat + deltaLong * deltaLong);
        return new Distance(distance, this);
    }

    public String toString() {
        return this.neighborhood();
    }
}
