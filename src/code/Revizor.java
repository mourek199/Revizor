package code;

public class Revizor {
    private Location currentLocation;
    private Location headingLocation;
    private String name;
    private int money;
    private int depression;
    private int timeElapsed = 0;
    private int rideTime = 0;

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
