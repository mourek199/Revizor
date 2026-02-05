package code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PassengerBuilder {
    public static ArrayList<String> ManNames;
    public static ArrayList<String> ManLastNames;
    public static ArrayList<String> WomanNames;
    public static ArrayList<String> WomanLastnames;
    public static HashMap<Integer, PassengerIdentification> identification;

    public PassengerBuilder() {
        try {
            this.ManNames = GameData.loadManNames();
            this.ManLastNames = GameData.loadManLastNames();
            this.WomanNames = GameData.loadWomanNames();
            this.WomanLastnames = GameData.loadWomanLastNames();
            identification = new HashMap<>();
            identification.put(0, new PassengerIdentification("Mobilní aplikace PID Lítačka", "green", 3));
            identification.put(1, new PassengerIdentification("Fyzická kartička PID Lítačka", "blue", 3));
            identification.put(2, new PassengerIdentification("Papírový lístek PID", "yellow", 3));
            identification.put(3, new PassengerIdentification("Žádný doklad", "red", 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getManNames() {
        return ManNames;
    }

    public ArrayList<String> getManLastNames() {
        return ManLastNames;
    }

    public ArrayList<String> getWomanNames() {
        return WomanNames;
    }

    public ArrayList<String> getWomanLastnames() {
        return WomanLastnames;
    }
}
