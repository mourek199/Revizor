package code;

import commands.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This class is used for typing and executing commands.
 * @author Tony
 */
public class GameConsole {

    private Scanner sc;
    private GameData gameData = new GameData();
    private GameMap gameMap = new GameMap();
    private Revizor revizor;
    private HashMap<String, Command> availableCommands;
    private String pickedName = "bezejmenný";
    private boolean shouldExit;

    public GameConsole() {
        shouldExit = false;
        availableCommands = new HashMap<>();
        sc = new Scanner(System.in);
        revizor = new Revizor(pickedName, gameMap);
    }


    /**
     *Initializes the game and creates the commands
     */
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
        availableCommands.put("mluv", new Talk(revizor, gameMap));
        //endregion
        //region passengerCheckCommand
        availableCommands.put("kontrola", new PassengerCheck(revizor, gameMap));
        availableCommands.put("check", new PassengerCheck(revizor, gameMap));
        //endregion
        //endregion

        loadStuff();
        revizor.setCurrentLocation(gameMap.getLocations()[7]);
        revizor.addItem(gameMap.getItems().get("bageta"));
    }

    /**
     * loads data from resource root
     */
    public void loadStuff(){
        try {
            gameData.loadMap(gameMap);
            gameData.loadItems(gameMap);
            gameData.loadNpcs(gameMap);
            PassengerBuilder pb = new PassengerBuilder();
            for (Location l:gameMap.getLocations()){
                for (int i = 0; i < l.getInnitPassengerSize(); i++) {
                    l.getPassengers().add(new Passenger());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Scans for input and executes desired command
     */
    public void execute(){
        System.out.print("\nZadej příkaz (pro nápovědu napiš pomoc/help)"+Tools.color("red", "\n>>"));
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

    public String setUsername(){
        Tools.consoleClear();
        System.out.println(Tools.color("red", Tools.line(50)));
        System.out.print("Zadej křestní jméno svého revizora: ");
        pickedName = sc.next();
        sc.nextLine();
        return pickedName;
    }
    /**
     * The whole game cycle. The cycle ends if any called command's exit method returns true
     */
    public void start(){
        innit();
        revizor.setName(setUsername());
        Story.intro();
        do {
            execute();
        } while (!shouldExit && !gameMap.mapCompleted());
        if (gameMap.mapCompleted()){
            Story.victory();
        }else {
            Story.altVictory();
        }
    }

}
