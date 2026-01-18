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
        String locInfo = "";
        for (int i = 0; i < locations.length; i++) {
            locInfo += locations[i].toString();
        }
        return "The game map consists of: " + locInfo;

    }
}
