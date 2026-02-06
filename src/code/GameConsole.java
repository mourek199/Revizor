package code;

import code.commands.*;

import java.io.IOException;
import java.util.Arrays;
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
        revizor = new Revizor("R", gameMap);
    }

    public void innit(){
        //region commandInnit
        //region moveCommand
        availableCommands.put("go", new Move(revizor, gameMap));
        availableCommands.put("jdi", new Move(revizor, gameMap));
        availableCommands.put("move", new Move(revizor, gameMap));
        //endregion
        // region waitCommand
        availableCommands.put("cekej", new Wait(revizor, gameMap));
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
        availableCommands.put("heeelp", new Help());
        //endregion
        //region bagCommand
        availableCommands.put("batoh", new Bag(revizor));
        availableCommands.put("bag", new Bag(revizor));
        availableCommands.put("inventory", new Bag(revizor));
        //endregion
        //region suicideCommand
        availableCommands.put("skok", new Suicide(revizor));
        availableCommands.put("jump", new Suicide(revizor));
        //endregion
        //region psychologistCommand
        availableCommands.put("psycholog", new Psychologist(revizor));
        availableCommands.put("psychologist", new Psychologist(revizor));
        availableCommands.put("psycho", new Psychologist(revizor));
        availableCommands.put("shrink", new Psychologist(revizor));
        availableCommands.put("deprese", new Psychologist(revizor));
        //endregion
        //region talkCommand
        availableCommands.put("talk", new Talk(revizor, gameMap));
        //endregion
        //region passengerCheckCommand
        availableCommands.put("kontrola", new PassengerCheck(revizor, gameMap));
        availableCommands.put("check", new PassengerCheck(revizor, gameMap));


        //endregion
        //endregion

        try {
            gameData.loadMap(gameMap);
            gameData.loadItems(gameMap);
            gameData.loadNpcs(gameMap);
            PassengerBuilder pb = new PassengerBuilder();
            System.out.println(pb.getManNames());
            System.out.println(pb.getWomanNames());
            System.out.println(pb.getManLastNames());
            System.out.println(pb.getWomanLastnames());
            for (Location l:gameMap.getLocations()){
                for (int i = 0; i < 3; i++) {
                    l.getPassengers().add(new Passenger());
                }
            }
            for (int i = 0; i < 5000; i++) {
                System.out.println(new Passenger());
            }
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
            System.out.println(Tools.color("red", "NEROZUMÍM TOMUTO PŘÍKAZU (Napiš \"help\" pro pomoc s příkazy)"));
        }
    }

    public void start(){
        innit();
        do {
            execute();
        } while (!shouldExit);
    }
}
