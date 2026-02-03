package code;

import java.io.IOException;
import java.util.ArrayList;

public class PassengerBuilder {
    public static ArrayList<String> ManNames;
    public static ArrayList<String> ManLastNames;
    public static ArrayList<String> WomanNames;
    public static ArrayList<String> WomanLastnames;
    public static ArrayList<Passenger> passengers;

    public PassengerBuilder() {
        try {
            this.ManNames = GameData.loadManNames();
            this.ManLastNames = GameData.loadManLastNames();
            this.WomanNames = GameData.loadWomanNames();
            this.WomanLastnames = GameData.loadWomanLastNames();

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
