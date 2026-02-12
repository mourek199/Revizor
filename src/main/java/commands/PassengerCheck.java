package commands;

import code.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class with all the passenger-checking logic
 * @author Tony
 */
public class PassengerCheck extends Command {

    private final Revizor revizor;
    private final GameMap gameMap;
    private final Random rd;
    private final Scanner sc;
    private final ArrayList<String> terminalColors;
    private PassengerIdentification currentPassengerIdentification;
    private boolean correctId;
    private boolean crimeIgnored;
    private boolean gaveFee;
    private boolean checkFinished = false;
    private boolean unrightfulFee = false;

    public PassengerCheck(code.Revizor revizor, GameMap gameMap) {
        this.revizor = revizor;
        this.gameMap = gameMap;
        rd = new Random();
        sc = new Scanner(System.in);
        this.terminalColors = new ArrayList<>();

    }

    /**
     * Lets player choose one present passenger and performs a passenger check
     */
    @Override
    public String execute() {
        Tools.consoleClear();
        System.out.println("Vyber si koho chceš zkontrolovat:");
        System.out.println(Tools.color("Red", "0) ") + "Zrušit kontrolu");
        int passengerIndex = 0;
        for (Passenger p : revizor.getCurrentLocation().getPassengers()) {
            passengerIndex++;
            System.out.println(Tools.color("Yellow", passengerIndex + ") ") + p);
        }
        int input;
        boolean checkCancelled = false;
        try{
            input = sc.nextInt();
            if (input == 0){
                checkCancelled = true;
            }
            revizor.setActivePassenger(revizor.getCurrentLocation().getPassengers().get(input - 1));
        }catch (InputMismatchException | IndexOutOfBoundsException e){
            Tools.consoleClear();
            sc.nextLine();
            if (checkCancelled){
                System.out.println("Kontrola byla zrušena.");
            }else{
                Tools.invalidInput();
            }
            return "Cestující nevybrán.";
        }

        Tools.consoleClear();
        System.out.println("Přiblížíš se k cestujícímu: " + revizor.getActivePassenger() + " a začíná kontrola.");
        Tools.pressEnter();
        Tools.consoleClear();
        System.out.println(revizor.getActivePassenger() + " využívá k identifikaci: " +
                Tools.color(PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getColor(),
                        PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getIdType()));
        revizorTerminal();
        if (checkFinished) {
            gameMap.getLocations()[revizor.getCurrentLocation().getPosition()].increasePassengersDone();
            gameMap.getLocations()[revizor.getCurrentLocation().getPosition()].getPassengers().removeIf(passenger ->
            passenger.equals(revizor.getActivePassenger()));

        }
        return "";
    }

    /**
     * All passenger-checking terminal functions in one spot
     */
    public void revizorTerminal() {
        boolean answered = false;
        int input;
        while (!answered) {
            printTerminalOptions();
            try {
                input = sc.nextInt()-1;
                currentPassengerIdentification = PassengerBuilder.identification.get(input);
            if (PassengerBuilder.identification.containsKey(input)){
                Tools.consoleClear();
                System.out.println("KLIK. Na svém terminálu jsi zvolil " + Tools.color(currentPassengerIdentification.getColor(), currentPassengerIdentification.getIdType()) + ".");
                answered = true;
            }else {
                sc.nextLine();
                Tools.didItWrong();
                System.out.println("Do háje. Já zapomněl co mi ukázal.. musím si vzpomenout");

            }
            } catch (InputMismatchException e) {
                sc.nextLine();
                Tools.didItWrong();
                System.out.println("Do háje. Já zapomněl co mi ukázal.. musím si vzpomenout...");

            }
        }
        Tools.pressEnter();
        Tools.consoleClear();
        correctId = PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getIdType().equals(currentPassengerIdentification.getIdType());
        decideFaith();
        checkResult();
        Tools.pressEnter();
        Tools.consoleClear();
    }

    /**
     * Lets player decide if the current passenger is free to go or needs to get fined
     */
    public void decideFaith() {
        boolean answered = false;
        while (!answered) {
            System.out.println("Nyní se rozhodni jak se k cestujícímu " + revizor.getActivePassenger() + " zachováš.");
            System.out.println(Tools.color("Yellow", "1)") + " \"Doklady máte vpořádku.\"");
            System.out.println(Tools.color("Yellow", "2)") + " \"Dostaneš pokutu, ty hajzle.\"");

            try{
                switch (sc.nextInt()) {
                    case 1 -> {
                        if (revizor.getActivePassenger().getUsedId() == 3) {
                            crimeIgnored = true;
                            System.out.println(Tools.color("red", "SAKRA! ") + "Měl sem černýmu pasažérovi dát pokutičku.. Achjo to sem blbec");
                            Tools.pressEnter();
                            Tools.consoleClear();
                        } else {
                            crimeIgnored = false;
                        }
                        gaveFee = false;
                        answered = true;
                    }
                    case 2 -> {
                        fee();
                        if (revizor.getActivePassenger().getUsedId() != 3){
                            unrightfulFee = true;
                        }
                        gaveFee = true;
                        answered = true;
                    }
                    default -> {
                        Tools.didItWrong();
                        sc.nextLine();
                    }
                }
            }catch (InputMismatchException e){
                sc.nextLine();
                Tools.didItWrong();
            }

        }
    }

    /**
     * Gives passenger a fee
     */
    public void fee() {
        Tools.consoleClear();
        System.out.print("Hehe.. Dám ");
        if (revizor.getActivePassenger().isFemale() && revizor.getActivePassenger().getAge() <= 30) {
            System.out.print("slečně");
        } else if (revizor.getActivePassenger().isFemale() && revizor.getActivePassenger().getAge() > 30) {
            System.out.print("paní");
        }
        if (!revizor.getActivePassenger().isFemale() && revizor.getActivePassenger().getAge() <= 30) {
            System.out.print("klukovi");
        } else if (!revizor.getActivePassenger().isFemale() && revizor.getActivePassenger().getAge() > 30) {
            System.out.print("pánovi");
        }
        System.out.println(" tučnou pokutičku... :)");
        Tools.pressEnter();
        Tools.consoleClear();
    }

    /**
     * Prints available identification options in random colors
     */
    public void printTerminalOptions() {
        System.out.println("přiřaď co pasažér používá za doklad:");
        terminalColors.add("green");
        terminalColors.add("blue");
        terminalColors.add("yellow");
        terminalColors.add("red");
        int num = 0;
        int randNum;
        for (PassengerIdentification pi : PassengerBuilder.identification.values()) {
            randNum = rd.nextInt(0, terminalColors.size());
            num++;
            System.out.println(Tools.color(terminalColors.get(randNum), num + ") " + pi.getIdType()));
            terminalColors.remove(terminalColors.get(randNum));
        }
    }

    /**
     * Prints a table with all necessary (and unnecessary!) details about the passenger check
     */
    public void checkResult(){
        Tools.consoleClear();
        int moneyForCheck = 100 + revizor.getDepression()*-10;
        int moneyForFee = 0;
        if (gaveFee){
            moneyForFee += 1500 - revizor.getActivePassenger().getAge()*10;
        }
        int totalDepression = 0;
        if (!correctId){
            totalDepression+=3;
        }
        if (crimeIgnored || unrightfulFee){
            totalDepression+=150;
        }
        int totalMoney = moneyForCheck + moneyForFee;
        revizor.setMoney(revizor.getMoney() + totalMoney);
        revizor.setDepression(revizor.getDepression() + totalDepression);
        checkFinished = true;

        System.out.println(Tools.color("red", "         -VÝSLEDEK PŘEPRAVNÍ KONTROLY- "));
        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.println("•Kontrolu provedl: " + Tools.color("yellow", revizor.getName()));
        System.out.println("•Kontrolovaná osoba: " + Tools.color("yellow", revizor.getActivePassenger().getFirstName() + " " + revizor.getActivePassenger().getLastName()));
        System.out.println("•Věk kontrolované osoby: " + Tools.color("yellow", "" +revizor.getActivePassenger().getAge()));
        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.println("•Zvolený doklad: " + Tools.color(currentPassengerIdentification.getColor(), currentPassengerIdentification.getIdType()));
        System.out.println("•Skutečný doklad: " + Tools.color(PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getColor(), PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getIdType()));
        System.out.print("•Revizor zvládl přiřadit: ");
        if (correctId){
            System.out.println(Tools.color("Yellow", "Kupodivu ano"));
        }else {
            System.out.println(Tools.color("Yellow", "Bohužel ne"));
        }
        System.out.print("•Udělil pokutu: ");
        if (crimeIgnored){
            System.out.println(Tools.color("red", "No.. ne"));
        }else if (unrightfulFee){
            System.out.println(Tools.color("red", "Ano, ale chudák si to nezasloužil"));
        }else if (gaveFee){
            System.out.println(Tools.color("Yellow", "Ano. Oprávněně."));
        }else {
            System.out.println(Tools.color("Yellow", "Ne. Není nutno."));
        }
        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.print("•Zisk za kontrolu: ");
        if (moneyForCheck >= 0){System.out.println(Tools.color("yellow", "+" + moneyForCheck + "kč"));
        }else {
            System.out.println(Tools.color("red",moneyForCheck + "kč"));
        }
        System.out.print("•Zisk za pokuty: ");
        if (gaveFee){
            System.out.println(Tools.color("Yellow", moneyForFee + "kč"));
        }else {
            System.out.println(Tools.color("Red", "---"));
        }
        System.out.print("•Zisk celkem: ");
            if (totalMoney >=0){
                System.out.println(Tools.color("Yellow", totalMoney + "kč"));
            }else {
                System.out.println(Tools.color("Red", totalMoney + "kč"));
            }

        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.print("•Zhoršení psychického stavu o: ");
        if (totalDepression != 0){
            System.out.println(Tools.color("red", String.valueOf(totalDepression)));
        }else {
            System.out.println(Tools.color("Yellow", "stav nezměněn"));
        }
        System.out.println((Tools.color("red",Tools.line(50))));
    }

    @Override
    public boolean exit() {
        return false;
    }
}
