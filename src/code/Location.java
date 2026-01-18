package code;

import java.util.Arrays;

public class Location {
    private String name;
    private String welcomeMessage;
    private String description;
    private int[] passengers;
    private int position;

    public Location() {
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

    public int[] getPassengers() {
        return passengers;
    }

    public void setPassengers(int[] passengers) {
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
        return "Location{" +
                "name='" + name + '\'' +
                ", welcomeMessage='" + welcomeMessage + '\'' +
                ", description='" + description + '\'' +
                ", passengers=" + Arrays.toString(passengers) +
                ", position=" + position +
                '}';
    }
}


