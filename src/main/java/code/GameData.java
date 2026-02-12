package code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;

/**
 * This class is used for loading stuff
 * @author Tony
 */
public class GameData {

    /**
     * loads all locations from json into the game map
     * @param gameMap
     */
    public void loadMap(GameMap gameMap) {
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = new FileInputStream("res/dataLocations.json")) {
            gameMap.setLocations(mapper.readValue(input, Location[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * loads all Npcs from json into the game map
     * @param gameMap
     */
    public void loadNpcs(GameMap gameMap) {
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = new FileInputStream("res/dataNpcs.json")) {
            Npc[] npcs = mapper.readValue(input, Npc[].class);
            for(Npc npc : npcs) {
                gameMap.getNpcs().put(npc.getName(), npc);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * loads all items from json to game map
     * @param gameMap
     */
    public void loadItems(GameMap gameMap) {
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = new FileInputStream("res/dataItems.json")) {
            Item[] items = mapper.readValue(input, Item[].class);
            for(Item item : items) {
                gameMap.getItems().put(item.getName(), item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * loads all man first names from text file
     * @return ArrayList of all names
     * @throws IOException
     */
    public static ArrayList<String> loadManNames() throws IOException {
        ArrayList<String> loadedManNames = new ArrayList<>();
        String currentLine = "";
        BufferedReader br = new BufferedReader(new FileReader("res/manNames.txt"));
        while((currentLine = br.readLine()) != null) {
            loadedManNames.add(currentLine);
        }
        return loadedManNames;
    }

    /**
     * loads all woman first names from text file
     * @return ArrayList of all names
     * @throws IOException
     */
    public static ArrayList<String> loadWomanNames() throws IOException {
        ArrayList<String> loadedWomanNames = new ArrayList<>();
        String currentLine = "";
        BufferedReader br = new BufferedReader(new FileReader("res/womanNames.txt"));
        while((currentLine = br.readLine()) != null) {
            loadedWomanNames.add(currentLine);
        }
        return loadedWomanNames;
    }

    /**
     * loads all woman last names from text file
     * @return ArrayList of all names
     * @throws IOException
     */
    public static ArrayList<String> loadWomanLastNames() throws IOException {
        ArrayList<String> loadedWomanLastNames = new ArrayList<>();
        String currentLine = "";
        BufferedReader br = new BufferedReader(new FileReader("res/womanLastnames.txt"));
        while((currentLine = br.readLine()) != null) {
            loadedWomanLastNames.add(currentLine);
        }
        return loadedWomanLastNames;
    }

    /**
     * loads all man last names from text file
     * @return ArrayList of all names
     * @throws IOException
     */
    public static ArrayList<String> loadManLastNames() throws IOException {
        ArrayList<String> loadedManLastNames = new ArrayList<>();
        String currentLine = "";
        BufferedReader br = new BufferedReader(new FileReader("res/manLastnames.txt"));
        while((currentLine = br.readLine()) != null) {
            loadedManLastNames.add(currentLine);
        }
        return loadedManLastNames;
    }
}
