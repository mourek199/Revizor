package code;

import java.util.ArrayList;

public class Revizor {
    private Location currentLocation;
    private Location headingLocation;
    private ArrayList<Item> items;
    private String name;
    private int money = 0;
    private int depression = Integer.MAX_VALUE;
    private int timeElapsed = 0;
    private int rideTime = 0;

    public Revizor(String name, GameMap gameMap) {
        currentLocation = new Location();
        items = new ArrayList<>();
        this.name = name;
    }


    public boolean addItem(Item item) {
        items.add(item);
        return true;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDepression() {
        return depression;
    }

    public void setDepression(int depression) {
        this.depression = depression;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setHeadingLocation(Location headingLocation) {
        this.headingLocation = headingLocation;
    }

    public Location getHeadingLocation() {
        return headingLocation;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public int getRideTime() {
        return rideTime;
    }

    public void setRideTime(int rideTime) {
        this.rideTime = rideTime;
        timeElapsed = 0;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public boolean isTravelling(){
        return rideTime > 0;
    }

    public String situation(){
        if (isTravelling()){
            return "Jedeš na " + Tools.color("blue", headingLocation.getName()) + " (" +Math.round(timeElapsed/((double)rideTime/100)) + "%"+ ")";
        }else {
            return "Nacházíš se na " + Tools.color("blue", currentLocation.getName());
        }
    }

    @Override
    public String toString() {
        return  Tools.line(50) +
                "\nName: " + name +
                "\ncurrentLocation: " + currentLocation.getName() +
                "\nMoney: " + money+
                "\nDepression: " + depression +
                "\n" + Tools.line(50);
    }
}
