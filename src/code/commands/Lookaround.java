package code.commands;

import code.GameMap;
import code.Revizor;
import code.Tools;

/**
 * Used to give the player a description of the current location they're in
 * @author Tony
 */
public class Lookaround extends Command {
    private Revizor revizor;
    private GameMap gameMap;

    /**
     * prints location description, number of passengers and NPC's names if present
     */
    @Override
    public String execute() {
        Tools.consoleClear();
        System.out.println(revizor.getCurrentLocation().getDescription());
        System.out.println("•Kolem tebe se nachází " + Tools.color("blue", String.valueOf(Integer.valueOf(gameMap.getLocations()[revizor.getCurrentLocation().getPosition()].getPassengers().size()))) +
                " nezkontrolovaných cestujících.");
        if (revizor.getCurrentLocation().getNpcsPresent().size() > 0) {
            System.out.println("•V této lokaci se nachází i další postavy: " + "\n");
            for (int i = 0; i < revizor.getCurrentLocation().getNpcsPresent().size(); i++) {
                System.out.println("•" + Tools.color("blue", revizor.getCurrentLocation().getNpcsPresent().get(i)) + " - " + gameMap.getNpcs().get(revizor.getCurrentLocation().getNpcsPresent().get(i)).getDescription());
            }
        }
        return "";
    }

    public Lookaround(Revizor revizor, GameMap gameMap) {
        this.revizor = revizor;
        this.gameMap = gameMap;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
