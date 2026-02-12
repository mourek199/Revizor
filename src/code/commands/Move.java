package code.commands;

import code.GameMap;
import code.Location;
import code.Revizor;
import code.Tools;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Command used for traveling from station to station
 */
public class Move extends Command {
    private Revizor revizor;
    private GameMap gameMap;
    private Scanner scMove;

    public Move(Revizor revizor, GameMap gameMap) {
        scMove = new Scanner(System.in);
        this.revizor = revizor;
        this.gameMap = gameMap;
    }

    /**
     * Lets player choose a station where to relocate themselves
     * @return current traveling status
     */
    @Override
    public String execute() {
        Tools.consoleClear();
        revizor.addItem(gameMap.getItems().get("bageta"));
        if (!revizor.isTravelling()) {
            int desiredLocation = 0;
            boolean answered = false;
                availableStations();
                System.out.println("Vyber si stanici, na kterou chceš cestovat (číslo) : ");
                while (!answered) {
                    try{
                        desiredLocation = scMove.nextInt();
                        answered = true;
                    }catch (InputMismatchException e){
                        Tools.invalidInput();
                        scMove.nextLine();
                    }
                }

                if (desiredLocation != revizor.getCurrentLocation().getPosition()) {
                    revizor.setHeadingLocation(gameMap.getLocations()[desiredLocation]);
                    scMove.nextLine();
                    revizor.setRideTime(Math.abs((revizor.getCurrentLocation().getPosition() - revizor.getHeadingLocation().getPosition())));
                    revizor.setCurrentLocation(gameMap.getLocations()[0]);
                }
                Tools.consoleClear();
                if (revizor.isTravelling()) {
                    System.out.println(Tools.color("blue", "\"" + revizor.getCurrentLocation().getWelcomeMessage() + "\""));
                }
                return revizor.situation();


            } else {
            Tools.consoleClear();
            return Tools.color("red", "NYNÍ NELZE CESTOVAT. VYČKEJ NA PŘÍJEZD DO STANICE");}
    }

    /**
     * prints the list of available stations
     */
    public void availableStations(){
        //region availableStationsPrint
        Tools.consoleClear();
        Location[] dirLetnany = Arrays.copyOfRange(gameMap.getLocations(), 1, revizor.getCurrentLocation().getPosition());
        Location[] dirIpak = Arrays.copyOfRange(gameMap.getLocations(), revizor.getCurrentLocation().getPosition() + 1, gameMap.getLocations().length);
        System.out.println(Tools.color("red", Tools.line(35)));
        for (int i = 0; i < dirLetnany.length; i++) {
            System.out.printf("%-30s %-8s%n",dirLetnany[i].getPosition() + ") " + dirLetnany[i].getName(), dirLetnany[i].getPercentage());
        }
        System.out.println(Tools.color("red", "^^^"));
        System.out.printf("%-30s %-8s%n", revizor.getCurrentLocation().getPosition() + ") " + revizor.getCurrentLocation().getName(), revizor.getCurrentLocation().getPercentage() );

        System.out.println(Tools.color("red", "VVV"));
        for (int i = 0; i < dirIpak.length; i++) {
            System.out.printf("%-30s %-8s%n",dirIpak[i].getPosition() + ") " + dirIpak[i].getName(), dirIpak[i].getPercentage());
        }
        System.out.println(Tools.color("red", Tools.line(35)));
        //endregion
    }

    @Override
    public boolean exit() {
        return false;
    }
}
