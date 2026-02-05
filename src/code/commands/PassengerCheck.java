package code.commands;
import code.*;

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
        System.out.println("Přiblížíš se k cestujícímu: " +revizor.getActivePassenger() + " a začíná kontrola.");
        Tools.pressEnter();
        Tools.consoleClear();
        System.out.println(revizor.getActivePassenger() + " využívá k identifikaci: " +
                           Tools.color(PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getColor(),
                           PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getIdType()));
        Tools.pressEnter();
        Tools.consoleClear();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
