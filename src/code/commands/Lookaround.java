package code.commands;

import code.GameMap;
import code.Revizor;

public class Lookaround extends Command {
    Revizor revizor;
    GameMap gameMap;

    @Override
    public String execute() {
        return revizor.getCurrentLocation().getDescription() +
                "\nKolem tebe se nachází " + gameMap.getLocations()[revizor.getCurrentLocation().getPosition()].getPassengers().length;
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
