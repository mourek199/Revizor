package code;
import java.util.ArrayList;

/**
 *A location which can be visited by player
 * @author Tony
 */
public class Location {
    private String name;
    private String welcomeMessage;
    private String description;
    private ArrayList<String> npcsPresent;
    private ArrayList<Passenger> passengers;
    private int position;
    private int innitPassengerSize;
    private int passengersDone = 0;
    private double completion = 0;

    public Location() {
    }

    public double getCompletion(){
        this.completion = Math.round((passengersDone)/((double)innitPassengerSize/100));
        return this.completion;
    }

    public String getPercentage(){
        if (getCompletion() == 100.0){
            return Tools.color("Green"," (DOKONČENA!)");
        }else if(getCompletion()>0.0){
            return Tools.color("yellow"," (" +getCompletion() + "%)");
        }else{
            return Tools.color("red"," (" +getCompletion() + "%)");
        }
    }

    /**
     * @return if all the present passengers have been checked
     */
    public boolean isComplete(){
        return getCompletion() == 100.0;
    }

    public void increasePassengersDone(){
        passengersDone++;
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

    public int getInnitPassengerSize() {
        return innitPassengerSize;
    }

    public void setInnitPassengerSize(int innitPassengerSize) {
        this.innitPassengerSize = innitPassengerSize;
    }

    public int getPassengersDone() {
        return passengersDone;
    }

    public void setPassengersDone(int passengersDone) {
        this.passengersDone = passengersDone;
    }

    public void setCompletion(double completion) {
        this.completion = completion;
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


