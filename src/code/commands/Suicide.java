package code.commands;

import code.Revizor;
import code.Tools;

/**
 * This command lets player end the game early by commiting suicide
 * @author Tony
 */
public class Suicide extends Command {

    private Revizor revizor;

    @Override
    /**
     * checks if the player is able to commit suicide by calling exit() method
     */
    public String execute() {
        Tools.consoleClear();
        if(!revizor.getCurrentLocation().getName().equalsIgnoreCase("metro")){
            if (exit()){
                return "hop! ndjfkjdsnfkndsfnsiofndfn (You krilled yourself)";
            } else return "Hm.. To by bylo zajímavý no, ale nemůžu skočit pod metro.. to nám v DPP přísně zakázali";
        }else {
            return  "Asi jen težko budu skákat pod koleje zevnitř metra...";
        }
    }

    /**
     * calculates if the player is able to commit the action depending on depression status and location
     */
    @Override
    public boolean exit() {
        if (revizor.getDepression() > 30 && !revizor.getCurrentLocation().getName().equalsIgnoreCase("metro")){
            return true;
        } else return false;
    }

    public Suicide(code.Revizor revizor){
        this.revizor = revizor;
    }
}
