package code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GameData {

    private GameMap gameMap = new GameMap();

    public void loadMap() {
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = new FileInputStream("res/dataFile.json")) {
            gameMap.setLocations(mapper.readValue(input, Location[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GameMap getGameMap() {
        return gameMap;
    }
}
