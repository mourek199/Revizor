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
        InputStream input = GameData.class.getResourceAsStream("/dataLocations.json");
        if(input == null){
            throw new RuntimeException();
        }
        try(input) {
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
        InputStream input = GameData.class.getResourceAsStream("/dataNpcs.json");
        if (input == null){
            throw new RuntimeException();
        }
        try(input) {
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
        InputStream input = GameData.class.getResourceAsStream("/dataItems.json");
        if (input == null){
            throw new RuntimeException();
        }
        try(input) {
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
        InputStream input = GameData.class.getResourceAsStream("/manNames.txt");
        if(input == null){
            throw new RuntimeException();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = "";
        while(line!=null){
            line = br.readLine();
            loadedManNames.add(line);
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
        InputStream input = GameData.class.getResourceAsStream("/womanNames.txt");
        if(input == null){
            throw new RuntimeException();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = "";
        while(line!=null){
            line = br.readLine();
            loadedWomanNames.add(line);
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
        InputStream input = GameData.class.getResourceAsStream("/womanLastnames.txt");
        if(input == null){
            throw new RuntimeException();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = "";
        while(line!=null){
            line = br.readLine();
            loadedWomanLastNames.add(line);
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
        InputStream input = GameData.class.getResourceAsStream("/manLastnames.txt");
        if(input == null){
            throw new RuntimeException();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = "";
        while(line!=null){
            line = br.readLine();
            loadedManLastNames.add(line);
        }
        return loadedManLastNames;
    }

    public static ArrayList<String> poem() throws IOException {
        ArrayList<String> poem = new ArrayList<>();
        InputStream input = GameData.class.getResourceAsStream("/poem.txt");
        if(input == null){
            throw new RuntimeException();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = "";
        while(line!=null){
            line = br.readLine();
            poem.add(line);
        }
        return poem;
    }
}
