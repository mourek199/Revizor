package code;

import code.commands.Command;
import code.commands.Lookaround;
import code.commands.Move;
import code.commands.Wait;

import java.util.HashMap;
import java.util.Scanner;

public class GameConsole {

    private Scanner sc;
    private GameData gameData = new GameData();
    private Revizor revizor;
    private HashMap<String, Command> availableCommands;
    private boolean shouldExit;

    public GameConsole() {
        shouldExit = false;
        availableCommands = new HashMap<>();
        sc = new Scanner(System.in);
        revizor = new Revizor("revizorek");

    }

    public void innit(){
        availableCommands.put("nastup", new Move(revizor, gameData.getGameMap() ));
        availableCommands.put("cekej", new Wait(revizor, gameData.getGameMap() ));
        availableCommands.put("Lookaround", new Lookaround());

        try {
            gameData.loadMap();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void execute(){
        System.out.print(">>");
        String inputCommand = sc.next().toLowerCase();
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
