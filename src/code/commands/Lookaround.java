package code.commands;

import code.GameMap;
import code.Revizor;
import code.Tools;

public class Lookaround extends Command {
    private Revizor revizor;
    private GameMap gameMap;

    @Override
    public String execute() {
        Tools.consoleClear();
        return revizor.getCurrentLocation().getDescription() +
                "\nKolem tebe se nachází " + gameMap.getLocations()[revizor.getCurrentLocation().getPosition()].getPassengers().length + " cestujících.";
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
