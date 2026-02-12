package code.commands;

import code.GameMap;
import code.Revizor;
import code.Tools;

import java.util.Scanner;

/**
 * Waiting lets player skip time
 * @author Tony
 */
public class Wait extends Command {

    private Revizor revizor;


    public Wait(Revizor revizor, GameMap gameMap) {
        this.revizor = revizor;
    }

    /**
     *Shortens waiting time needed to arrive to station by 1 point
     * @return
     */
    @Override
    public String execute() {
        Tools.consoleClear();
        if (revizor.getCurrentLocation().getName() != null && revizor.getCurrentLocation().getName().equalsIgnoreCase("Metro")){
            shortRest();
            isArrived();
            return revizor.situation();
        }
        else return Tools.unAvailableCommand();
    }

    /**
     * Shortens the ride waiting time by 1 point
     * @return the time elapsed in the metro (1 larger than before method call)
     */
    public int shortRest(){
        revizor.setTimeElapsed(revizor.getTimeElapsed() + 1);
        return revizor.getTimeElapsed();
    }

    /**
     *Checks if player arrived. If so, then sets CurrentLocation to desired location
     * @return whether the player already arrived to desired location (true/false)
     */
    public boolean isArrived(){
        if (revizor.getTimeElapsed() >= revizor.getRideTime()){
            revizor.setCurrentLocation(revizor.getHeadingLocation());
            revizor.setRideTime(0);
            System.out.println(Tools.color("blue", "\""+revizor.getCurrentLocation().getWelcomeMessage()+"\""));
            return true;
        } else return false;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
