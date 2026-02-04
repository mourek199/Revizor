package code.commands;
import code.GameMap;
import code.Passenger;
import code.Revizor;
import code.Tools;

import java.util.Scanner;

public class PassengerCheck extends Command {

    private Revizor revizor;
    private GameMap gameMap;
    Scanner sc = new Scanner(System.in);

    public PassengerCheck(code.Revizor revizor, GameMap gameMap) {
        this.revizor = revizor;
        this.gameMap = gameMap;
    }

    @Override
    public String execute() {
        Tools.consoleClear();
        System.out.println("Vyber si koho chceš zkontrolovat:");
        int passengerIndex = 0;
        for(Passenger p : revizor.getCurrentLocation().getPassengers()) {
            passengerIndex++;
            System.out.println(passengerIndex + ") " + p);
        }
        revizor.setActivePassenger(revizor.getCurrentLocation().getPassengers().get(sc.nextInt()-1));
        Tools.consoleClear();
        System.out.println("Přiblížíš se k "+revizor.getActivePassenger() + " a začíná kontrola.");
        Tools.pressEnter();
        Tools.consoleClear();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
