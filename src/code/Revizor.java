package code;

import java.util.ArrayList;

/**
 * Revizor/Player class. This class stores necessary player data and functions
 * @author Tony
 */
public class Revizor {
    private GameMap gameMap;
    private Location currentLocation;
    private Location headingLocation;
    private ArrayList<Item> items;
    private Npc activeNpc;
    private Passenger activePassenger;
    private String name;
    private int capacity = 5;
    private int money = 0;
    private int depression = 12;
    private int timeElapsed = 0;
    private int rideTime = 0;

    public Revizor(String name, GameMap gameMap) {
        currentLocation = new Location();
        items = new ArrayList<>();
        this.name = name;
        this.gameMap = gameMap;
    }

    /**
     *
     * @param item Defines what item is added to player's inventory
     * @return whether the item was succesfully added
     */
    public boolean addItem(Item item) {
        if (items.size()+1 <= capacity) {
            items.add(item);
            return true;
        }else return false;
    }

    /**
     *
     * @param itemName Defines what item should be removed from player's inventory
     * @return whether the demanded item was removed from players inventory
     */
    public boolean removeItem(String itemName) {
        if (gameMap.getItems().containsKey(itemName) && items.contains(gameMap.getItems().get(itemName))) {
            items.remove(gameMap.getItems().get(itemName));
            return true;
        }else return false;
    }

    /**
     *
     * @param itemName Defines the name of item which is about to be consumed and removed from player's inventory
     * @return information about consuming
     */
    public String consumeItem(String itemName) {
        if (items.contains(gameMap.getItems().get(itemName))) {
            depression += gameMap.getItems().get(itemName).getDepressionChange();
            System.out.println(gameMap.getItems().get(itemName).getConsumeMessage());
            items.remove(gameMap.getItems().get(itemName));
            return "Použil jsi/sežral " + Tools.color("blue", itemName);
        }
        else return "Nebudu to jíst.";
    }

    public String getName() {
        return name;
    }

    public Npc getActiveNpc() {
        return activeNpc;
    }

    public void setActiveNpc(Npc activeNpc) {
        this.activeNpc = activeNpc;
    }

    public Passenger getActivePassenger() {
        return activePassenger;
    }

    public void setActivePassenger(Passenger activePassenger) {
        this.activePassenger = activePassenger;
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
