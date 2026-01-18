package code;

import java.util.Arrays;

public class GameMap {
    private Location[] locations;

    public GameMap() {
        locations = new Location[13];
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "GameMap{" +
                "locations=" + Arrays.toString(locations) +
                '}';
    }
}
