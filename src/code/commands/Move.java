package code.commands;

import code.GameMap;
import code.Location;
import code.Revizor;
import code.Tools;

import java.util.Arrays;
import java.util.Scanner;

public class Move extends Command {
    Revizor revizor;
    GameMap gameMap;
    Scanner scMove;

    public Move(Revizor revizor, GameMap gameMap) {
        scMove = new Scanner(System.in);
        this.revizor = revizor;
        this.gameMap = gameMap;
    }

    @Override
    public String execute() {
        if (!revizor.isTravelling()) {
            try {
                availableStations();
                revizor.setHeadingLocation(gameMap.getLocations()[scMove.nextInt()]);
                scMove.nextLine();
                revizor.setRideTime(Math.abs((revizor.getCurrentLocation().getPosition() - revizor.getHeadingLocation().getPosition())*2));
                revizor.setCurrentLocation(gameMap.getLocations()[0]);
                System.out.println(revizor.getCurrentLocation().getName());
                Tools.consoleClear();
                return revizor.situation();

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                return Tools.color("red", "ZVOLENÁ STANICE NEEXISTUJE");
            }
        } else {
            Tools.consoleClear();
            return "NYNÍ NELZE CESTOVAT. VYČKEJ NA PŘÍJEZD DO STANICE";}
    }

    public void availableStations(){
        //region availableStationsPrint
        Tools.consoleClear();
        revizor.setCurrentLocation(gameMap.getLocations()[7]);
        Location[] dirLetnany = Arrays.copyOfRange(gameMap.getLocations(), 1, revizor.getCurrentLocation().getPosition());
        Location[] dirIpak = Arrays.copyOfRange(gameMap.getLocations(), revizor.getCurrentLocation().getPosition() + 1, gameMap.getLocations().length);
        System.out.println(Tools.color("red", Tools.line(20)));
        for (int i = 0; i < dirLetnany.length; i++) {
            System.out.print(dirLetnany[i].getPosition() + ") " + dirLetnany[i].getName() + "\n");
        }
        System.out.println(Tools.color("red", "^^^"));
        System.out.println(revizor.getCurrentLocation().getPosition() + ") " + revizor.getCurrentLocation().getName() + " (Zde stojíte)");

        System.out.println(Tools.color("red", "VVV"));
        for (int i = 0; i < dirIpak.length; i++) {
            System.out.print(dirIpak[i].getPosition() + ") " + dirIpak[i].getName() + "\n");
        }
        System.out.println(Tools.color("red", Tools.line(20)));
        System.out.println("Vyber si stanici, na kterou chceš cestovat (číslo) : ");
        //endregion
    }

    @Override
    public boolean exit() {
        return false;
    }
}
