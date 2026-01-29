package code;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMap {
    private Location[] locations;
    private HashMap<String, Item> items;
    private ArrayList<Npc> npcs;

    public GameMap() {
        locations = new Location[12];
        items = new HashMap<>();
        npcs = new ArrayList<>();
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

    public void setNpcs(ArrayList<Npc> npcs) {
        this.npcs = npcs;
    }

    public ArrayList<Npc> getNpcs() {
        return npcs;
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
