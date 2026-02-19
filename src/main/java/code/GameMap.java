package code;

import java.util.HashMap;

/**
 * This class stores all game locations, items and characters
 * @author Tony
 */
public class GameMap {
    private Location[] locations;
    private HashMap<String, Item> items;
    private HashMap<String, Npc> npcs;

    public GameMap() {
        locations = new Location[12];
        items = new HashMap<>();
        npcs = new HashMap<>();
    }

    /**
     *
     * @return whether all stations in the game are completed
     */
    public boolean mapCompleted(){
        for (Location location : locations){
            if (!location.isComplete() && !location.getName().equalsIgnoreCase("metro")){
                return false;
            }
        }
        return true;

    }

    public Location[] getLocations() {
        return locations;
    }
    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }

    public HashMap<String, Npc> getNpcs() {
        return npcs;
    }

    public void setNpcs(HashMap<String, Npc> npcs) {
        this.npcs = npcs;
    }

    @Override
    public String toString() {
        String locInfo = "";
        for (int i = 0; i < locations.length; i++) {
            locInfo += locations[i].toString();
        }
        return "The game map consists of: " + locInfo + Tools.color("blue", "\n_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

    }
}
