package commands;

import code.Revizor;
import code.Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It's a backpack
 * @author Tony
 */
public class Bag extends Command {

    private Revizor revizor;
    Scanner sc = new Scanner(System.in);


    public Bag(code.Revizor revizor) {
        this.revizor = revizor;
    }

    /**
     * prints the contents of players inventory and lets player interact with items and consume consumable items
     *
     * @return it doesn't
     */
    @Override
    public String execute() {
        Tools.consoleClear();
        System.out.println(Tools.color("red", Tools.line(100)));
        wallet();
        System.out.println(Tools.color("red", Tools.line(100)));
        if (!revizor.getItems().isEmpty()) {
            System.out.println("Ve tvé revizorské brašně se nachází tyto předměty:");
            for (int i = 0; i < revizor.getItems().size(); i++) {
                System.out.println("  " + (i + 1) + ") " + revizor.getItems().get(i).getName());
            }
            System.out.println(Tools.color("red", Tools.line(100)));
            System.out.println("Chceš-li se dozvědět více o daném předmětu, či předmět použít, zadej jeho číslo: ");
            code.Item tempItem = new code.Item();
            boolean answered1 = false;
            while (!answered1) {
                try {
                    tempItem = revizor.getItems().get(sc.nextInt() - 1);
                    answered1 = true;
                } catch (InputMismatchException | IndexOutOfBoundsException e) {
                    Tools.invalidInput();
                    sc.nextLine();
                }
            }

            Tools.consoleClear();
            System.out.println(Tools.color("blue", tempItem.getName()) + " - " + tempItem.getDescription() + "\n");
            if (tempItem.isConsumable()) {
                System.out.println("Tento předmět vypadá, že se dá sníst. \nPřeješ si sníst " + Tools.color("blue", tempItem.getName()) + " ?" + Tools.yesNo());
                boolean answered2 = false;
                String input;
                while (!answered2) {
                    input = sc.next();
                    if (input.equalsIgnoreCase("A")) {
                        Tools.consoleClear();
                        System.out.println(revizor.consumeItem(tempItem.getName()));
                        Tools.pressEnter();
                        answered2 = true;
                    } else if (input.equalsIgnoreCase("N")) {
                        Tools.consoleClear();
                        System.out.println("Rozhodl jsi se předmět nekonzumovat");
                        answered2 = true;
                    } else {
                        sc.nextLine();
                        Tools.invalidInput();
                    }
                }
            }
            Tools.pressEnter();
            Tools.consoleClear();
            System.out.println("Zavřel jsi zip od své brašny a zase se věnuješ okolnímu světu.");
            Tools.pressEnter();

        } else {
            System.out.println("A sakra... moje brašna je prázdná... achjo... já doufal že tu něco bude...");
            System.out.println(Tools.color("red", Tools.line(100)));
            Tools.pressEnter();
        }
        Tools.consoleClear();
        return "";
    }

    public String wallet() {
        System.out.print("Tvoje peníze: ");
        if (revizor.getMoney() >= 0) {
            return Tools.color("yellow", (revizor.getMoney()) + "kč");
        } else {
            return Tools.color("red", (revizor.getMoney()) + "kč");
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
