package code;

import java.util.ArrayList;

public class Revizor {
    private GameMap gameMap;
    private Location currentLocation;
    private Location headingLocation;
    private ArrayList<Item> items;
    private Npc activeNpc;
    private String name;
    private int capacity = 5;
    private int money = 0;
    private int depression = 31;
    private int timeElapsed = 0;
    private int rideTime = 0;

    public Revizor(String name, GameMap gameMap) {
        currentLocation = new Location();
        items = new ArrayList<>();
        this.name = name;
        this.gameMap = gameMap;
    }

    public boolean addItem(Item item) {
        if (items.size()+1 <= capacity) {
            items.add(item);
            return true;
        }else return false;
    }

    public boolean removeItem(String itemName) {
        if (gameMap.getItems().containsKey(itemName) && items.contains(gameMap.getItems().get(itemName))) {
            items.remove(gameMap.getItems().get(itemName));
            return true;
        }else return false;
    }

    public String consumeItem(String itemName) {
        if (items.contains(gameMap.getItems().get(itemName))) {
            depression += gameMap.getItems().get(itemName).getDepressionChange();
            items.remove(gameMap.getItems().get(itemName));
            return "Použil jsi/sežral " + Tools.color("blue", itemName);
        }
        else return "Nebudu to jíst.";
    }

    public Npc getActiveNpc() {
        return activeNpc;
    }

    public void setActiveNpc(Npc activeNpc) {
        this.activeNpc = activeNpc;
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
