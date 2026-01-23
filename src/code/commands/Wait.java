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
            System.out.print(revizor.situation());
            return "";
        }
        else return Tools.unAvailableCommand();
    }

    public int finishRide(){
        revizor.setRideTime(0);
        revizor.isTravelling();
        return revizor.getRideTime();
    }

    public int shortRest(){
        revizor.setTimeElapsed(revizor.getTimeElapsed() + 3);
        System.out.println(revizor.getTimeElapsed());
        System.out.println(revizor.getRideTime());
        return revizor.getTimeElapsed();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
