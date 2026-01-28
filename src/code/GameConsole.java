package code;

import code.commands.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class GameConsole {

    private Scanner sc;
    private GameData gameData = new GameData();
    private GameMap gameMap = new GameMap();
    private Revizor revizor;
    private HashMap<String, Command> availableCommands;
    private boolean shouldExit;

    public GameConsole() {
        shouldExit = false;
        availableCommands = new HashMap<>();
        sc = new Scanner(System.in);
        revizor = new Revizor("R");
    }

    public void innit(){
        //region commandInnit
        //region moveCommand
        availableCommands.put("nastup", new Move(revizor, gameMap));
        availableCommands.put("go", new Move(revizor, gameMap));
        availableCommands.put("jdi", new Move(revizor, gameMap));
        availableCommands.put("bez", new Move(revizor, gameMap));
        availableCommands.put("běž", new Move(revizor, gameMap));
        availableCommands.put("move", new Move(revizor, gameMap));
        //endregion

        // region waitCommand
        availableCommands.put("cekej", new Wait(revizor, gameMap));
        availableCommands.put("čekej", new Wait(revizor, gameMap));
        availableCommands.put("wait", new Wait(revizor, gameMap));
        //endregion

        //region lookaroundCommand
        availableCommands.put("lookaround", new Lookaround(revizor, gameMap));
        availableCommands.put("kochat", new Lookaround(revizor, gameMap));
        availableCommands.put("kochatse", new Lookaround(revizor, gameMap));
        //endregion

        //region helpCommand
        availableCommands.put("help", new Help());
        availableCommands.put("pomoc", new Help());
        //endregion

        //region Bag
        availableCommands.put("batoh", new Bag(revizor));
        availableCommands.put("bag", new Bag(revizor));
        availableCommands.put("inventory", new Bag(revizor));
        //endregion

        //region suicide
        availableCommands.put("skok", new Suicide());
        //endregion

        //region psychologist
        availableCommands.put("psycholog", new Psychologist(revizor));
        //endregion
        //endregion

        try {
            System.out.println(gameData.loadManNames());
            System.out.println(gameData.loadManLastNames());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            gameData.loadMap(gameMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        revizor.setCurrentLocation(gameMap.getLocations()[7]);
    }

    public void execute(){
        System.out.print(">>");
        String inputCommand = sc.next().toLowerCase().trim();
        sc.nextLine();

        if(availableCommands.containsKey(inputCommand)){
            System.out.println(availableCommands.get(inputCommand).execute());
            shouldExit = availableCommands.get(inputCommand).exit();
        }
        else {
            System.out.println(Tools.color("red", "NEROZUMÍM TOMUTO PŘÍKAZU"));
        }
    }

    public void start(){
        innit();
        do {
            execute();
        } while (!shouldExit);
    }
}
