package code;

import java.io.IOException;
import java.util.ArrayList;

public class PassengerBuilder {
    private ArrayList<String> ManNames;
    private ArrayList<String> ManLastNames;
    private ArrayList<String> WomanNames;
    private ArrayList<String> WomanLastnames;
    private ArrayList<Passenger> passengers;

    public PassengerBuilder() {
        try {
            this.ManNames = GameData.loadManNames();
            this.ManLastNames = GameData.loadManLastNames();
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
