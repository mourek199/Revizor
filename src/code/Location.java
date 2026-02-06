package code;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Location {
    private String name;
    private String welcomeMessage;
    private String description;
    private ArrayList<String> npcsPresent;
    private ArrayList<Passenger> passengers;
    private int position;

    public Location() {
    }

    public ArrayList<String> getNpcsPresent() {
        return npcsPresent;
    }

    public void setNpcsPresent(ArrayList<String> npcsPresent) {
        this.npcsPresent = npcsPresent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return  Tools.color("blue", Tools.line(20)) +
                "\nlocation name: " + name +
                "\ndescription: " + description +
                "\nwelcome message: " + welcomeMessage +
                "\npresent passengers: " + passengers +
                "\nposition: " + position;
    }
}


