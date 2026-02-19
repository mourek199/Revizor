package commands;

import code.Revizor;
import code.Story;
import code.Tools;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This command lets player end the game early by commiting suicide
 * @author Tony
 */
public class Suicide extends Command {

    private Revizor revizor;

    @Override
    /**
     * checks if the player is able to commit suicide by calling exit() method
     */
    public String execute() {
        Tools.consoleClear();
        if(!revizor.getCurrentLocation().getName().equalsIgnoreCase("metro")){
            if (exit()){
                System.out.println("poslední slova: ");
                sayLastWords();
                Story.altVictory();
                return "";
            } else return "Hm.. To by bylo zajímavý no, ale nemůžu skočit pod metro.. to nám v DPP přísně zakázali";
        }else {
            return  "Asi jen težko budu skákat pod koleje zevnitř metra...";
        }
    }

    /**
     * calculates if the player is able to commit the action depending on depression status and location
     */
    @Override
    public boolean exit() {
        if (revizor.getDepression() > 250 && !revizor.getCurrentLocation().getName().equalsIgnoreCase("metro")){
            return true;
        } else return false;
    }

    public void sayLastWords(){

        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("res/LastWords.txt", true));
            Scanner sc = new Scanner(System.in);
            bufferedWriter.newLine();
            bufferedWriter.write("\"" + sc.nextLine() + "\" - "+revizor.getName());
            bufferedWriter.flush();
        }catch (FileNotFoundException e){
            System.out.println(Tools.color("red", "CHYBA SOUBORU 1"));
        } catch (IOException e) {
            System.out.println(Tools.color("red", "CHYBA SOUBORU 2"));
        }
    }


    public Suicide(code.Revizor revizor){
        this.revizor = revizor;
    }
}
