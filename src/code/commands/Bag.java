package code.commands;

import code.Revizor;
import code.Tools;

import java.util.Scanner;

public class Bag extends Command {

    Revizor revizor;
    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        Tools.consoleClear();
        System.out.println(Tools.color("red", Tools.line(100)));
        if(!revizor.getItems().isEmpty()) {
            System.out.println("Ve tvé revizorské brašně se nachází tyto předměty:");
            for (int i = 0; i < revizor.getItems().size(); i++) {
                System.out.println("  " + (i+1) +") " + revizor.getItems().get(i).getName());
            }
            System.out.println(Tools.color("red", Tools.line(100)));
            System.out.println("Chceš-li se dozvědět více o daném předmětu, zadej jeho číslo:");
            try {
                code.Item tempItem = revizor.getItems().get(sc.nextInt()-1);
                Tools.consoleClear();
                System.out.println(Tools.color("blue", tempItem.getName()) +" - "+ tempItem.getDescription() + "\n");
                Tools.pressEnter();
                Tools.consoleClear();
            } catch (Exception e) {
                System.out.println(Tools.color("red", "VYBRAL JSI ŠPATNĚ"));
            }
        }else {
            System.out.println("A sakra... moje brašna je prázdná... achjo... já doufal že tu něco bude...");
            System.out.println(Tools.color("red", Tools.line(100)));
        }

        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public Bag(code.Revizor revizor) {
        this.revizor = revizor;
    }
}
