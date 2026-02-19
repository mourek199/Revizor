package code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Story, intro, poem and endings
 */
public class Story {
    public static ArrayList<String> poem;
    public static Scanner scStory = new Scanner(System.in);

    static {
        try {
            poem = GameData.poem();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void intro(){
        Tools.consoleClear();
        poem();
        Tools.freeze(1000);
        Tools.consoleClear();
        for (int i = 3; i > 0; i--) {
            System.out.print("\n" + Tools.color("green", i + "..."));
            Tools.freeze(750);
        }
        Tools.consoleClear();

    }

    public static void poem(){
        Tools.consoleClear();
        System.out.println("Opakovaně mačkej " + Tools.color("Blue", "ENTER") + " a čti");
        for (int i = 0; i<poem.size(); i++){
            Story.scStory.nextLine();
            System.out.print(Tools.color("Yellow",poem.get(i)));
        }
    }

    public static void victory(){
        Tools.consoleClear();
        System.out.println("No ježiši kriste já sem vyřízenej...\n" +
                "...\n" +
                "KONEČNĚ SEM VOLNEJ!\n" +
                "ANOOO!\n" +
                "UŽ NIC NEMUSIM!\n" +
                "ANOOO!\n" +
                "\n" +
                "Revizor úspěšně odpracoval dnešní den a zaplatil přibližně 1,2% svého dluhu.\n" +
                "Má radost protože může jít domů, nicméně jeho blbé hlavě revizorské nedochází,\n" +
                "že po zbytek roku musí stále chodit do práce. To už nás ovšem příliš nezajímá. \n" +
                Tools.color("Green", "KONEC HRY - VÝHRA"));
    }

    public static void altVictory(){
        Tools.consoleClear();
        System.out.println("Hop!\n" + Tools.color("red", "Vdhebxjndsndjbdjddjucdhnsxnxjjss..."));
    }
}
