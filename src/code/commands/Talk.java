package code.commands;

import code.GameMap;
import code.Npc;
import code.Revizor;
import code.Tools;

import java.util.Scanner;

public class Talk extends Command {
    private Revizor revizor;
    private GameMap gameMap;
    Scanner sc = new Scanner(System.in);

    public Talk(Revizor revizor, GameMap gameMap) {
        this.revizor = revizor;
        this.gameMap = gameMap;
    }

    @Override
    public String execute() {
        Tools.consoleClear();
        if (revizor.getCurrentLocation().getNpcsPresent()!=null) {
            System.out.println("Na " + Tools.color("blue", revizor.getCurrentLocation().getName()) + " se nachází tito lidé. Zadej jméno se kterým chceš mluvit: ");
            for (int i = 0; i < revizor.getCurrentLocation().getNpcsPresent().size(); i++) {
                System.out.println("•" + revizor.getCurrentLocation().getNpcsPresent().get(i) );
            }
            boolean answered = false;
            String input;
            while (!answered) {
                input = sc.next();
                if(gameMap.getNpcs().containsKey(input)) {
                    revizor.setActiveNpc(gameMap.getNpcs().get(input));
                    Tools.consoleClear();
                    System.out.println(revizor.getActiveNpc().getWelcomeMessage());
                    answered = true;
                }else{
                    System.out.println(Tools.color("red", "ŠPATNĚ ZADANÉ JMÉNO, ZKUS TO ZNOVU"));
                }
            }
        }else{
            System.out.println("V této lokaci nevidíš nikoho s kým bys mohl pokecat");
        }
        Tools.pressEnter();
        Tools.consoleClear();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
