package code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;

public class GameData {

    public void loadMap(GameMap gameMap) {
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = new FileInputStream("res/dataLocations.json")) {
            gameMap.setLocations(mapper.readValue(input, Location[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    public static ArrayList<String> loadManNames() throws IOException {
        ArrayList<String> loadedManNames = new ArrayList<>();
        String currentLine = "";
        BufferedReader br = new BufferedReader(new FileReader("res/manNames.txt"));
        while((currentLine = br.readLine()) != null) {
            loadedManNames.add(currentLine);
        }
        return loadedManNames;
    }

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
