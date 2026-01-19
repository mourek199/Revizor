package code;

public class Revizor {
    private Location currentLocation;
    private String name;
    private int money;
    private int depression;

    public Revizor(String name) {
        currentLocation = new Location();
        this.name = name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
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
