package code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class GameData {



    public void loadMap(GameMap gameMap) {
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = new FileInputStream("res/dataFile.json")) {
            gameMap.setLocations(mapper.readValue(input, Location[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> loadManNames() throws IOException {
        ArrayList<String> loadedManNames = new ArrayList<>();
        String currentLine = "";
        BufferedReader br = new BufferedReader(new FileReader("res/ManNames.txt"));
        while((currentLine = br.readLine()) != null) {
            loadedManNames.add(currentLine);
        }
        return loadedManNames;
    }

    public ArrayList<String> loadManLastNames() throws IOException {
        ArrayList<String> loadedManLastNames = new ArrayList<>();
        String currentLine = "";
        BufferedReader br = new BufferedReader(new FileReader("res/ManLastnames.txt"));
        while((currentLine = br.readLine()) != null) {
            loadedManLastNames.add(currentLine);
        }
        return loadedManLastNames;
    }
}
