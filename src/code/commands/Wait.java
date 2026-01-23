package code.commands;

import code.GameMap;
import code.Revizor;
import code.Tools;

import java.util.Scanner;

public class Wait extends Command {

    private Revizor revizor;
    private GameMap gameMap;

    public Wait(Revizor revizor, GameMap gameMap) {
        this.revizor = revizor;
        this.gameMap = gameMap;
    }
    @Override
    public String execute() {
        if (revizor.getCurrentLocation().getName() != null && revizor.getCurrentLocation().getName().equalsIgnoreCase("Metro")){
            Tools.consoleClear();
            shortRest();
            isArrived();
            System.out.print(revizor.situation());
            return "";
        }
        else return Tools.unAvailableCommand();
    }

    public int finishRide(){
        revizor.setRideTime(0);
        return revizor.getTimeElapsed();
    }

    public int shortRest(){
        revizor.setTimeElapsed(revizor.getTimeElapsed() + 1);
        return revizor.getTimeElapsed();
    }

    public boolean isArrived(){
        if (revizor.getTimeElapsed() >= revizor.getRideTime()){
            revizor.setCurrentLocation(revizor.getHeadingLocation());
            revizor.setRideTime(0);
            return true;
        } else return false;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
