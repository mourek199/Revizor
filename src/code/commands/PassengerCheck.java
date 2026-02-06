package code.commands;

import code.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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
        int passengerIndex = 0;
        for (Passenger p : revizor.getCurrentLocation().getPassengers()) {
            passengerIndex++;
            System.out.println(passengerIndex + ") " + p);
        }
        revizor.setActivePassenger(revizor.getCurrentLocation().getPassengers().get(sc.nextInt() - 1));
        Tools.consoleClear();
        System.out.println("Přiblížíš se k cestujícímu: " + revizor.getActivePassenger() + " a začíná kontrola.");
        Tools.pressEnter();
        Tools.consoleClear();
        System.out.println(revizor.getActivePassenger() + " využívá k identifikaci: " +
                Tools.color(PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getColor(),
                        PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getIdType()));
        revizorTerminal();
        return "";
    }

    /**
     * All passenger-checking terminal functions in one spot
     */
    public void revizorTerminal() {
        boolean answered = false;
        while (!answered) {
            printTerminalOptions();
            try {
                currentPassengerIdentification = PassengerBuilder.identification.get(sc.nextInt() - 1);
                Tools.consoleClear();
                System.out.println("KLIK. Na svém terminálu jsi zvolil " + Tools.color(currentPassengerIdentification.getColor(), currentPassengerIdentification.getIdType()) + ".");
                answered = true;
            } catch (InputMismatchException e) {
                Tools.invalidInput();
            }
        }
        Tools.pressEnter();
        Tools.consoleClear();
        correctId = PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getIdType().equals(currentPassengerIdentification.getIdType());
        decideFaith();
        checkResult();
    }

    /**
     * Lets player decide if the current passenger is free to go or needs to get fined
     */
    public void decideFaith() {
        boolean answered = false;
        while (!answered) {
            System.out.println("Nyní se rozhodni jak se k cestujícímu " + revizor.getActivePassenger() + " zachováš.");
            System.out.println("1) nechat být a jít dál");
            System.out.println("2) pokuta");

            switch (sc.nextInt()) {
                case 1 -> {
                    if (revizor.getActivePassenger().getUsedId() == 4) {
                        crimeIgnored = true;
                        System.out.println(Tools.color("red", "SAKRA! ") + "Měl sem černýmu pasažérovi dát pokutičku.. Achjo to sem blbec");
                    } else {
                        crimeIgnored = false;
                    }
                    answered = true;
                }
                case 2 -> {
                    fee();
                    gaveFee = true;
                    answered = true;
                }
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
        int totalMoney = moneyForCheck + moneyForFee;

        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.println(Tools.color("red", "        -VÝSLEDEK PŘEPRAVNÍ KONTROLY- "));
        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.println("•Kontrolu provedl: " + Tools.color("yellow", revizor.getName()));
        System.out.println("•Kontrolovaná osoba: " + Tools.color("yellow", revizor.getActivePassenger().getFirstName() + " " + revizor.getActivePassenger().getLastName()));
        System.out.println("•Věk kontrolované osoby: " + Tools.color("yellow", "" +revizor.getActivePassenger().getAge()));
        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.println("•Zvolený doklad: " + Tools.color(currentPassengerIdentification.getColor(), currentPassengerIdentification.getIdType()));
        System.out.println("•Skutečný doklad: " + Tools.color(PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getColor(), PassengerBuilder.identification.get(revizor.getActivePassenger().getUsedId()).getIdType()));
        System.out.print("•Revizor zvládl zvolit správně: ");
        if (correctId){System.out.println(Tools.color("Yellow", "Kupodivu ano"));
        }else System.out.println(Tools.color("Yellow", "Bohužel ne"));
        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.println(Tools.color("red", "                 -VYÚČTOVÁNÍ-"));
        System.out.println((Tools.color("red",Tools.line(50))));
        System.out.println("•Zisk za kontrolu: " + Tools.color("Yellow", String.valueOf(moneyForCheck)));
        System.out.print("•Zisk za pokuty: ");
        if (gaveFee){System.out.println(Tools.color("Yellow", String.valueOf(moneyForFee)));
        }else System.out.println(Tools.color("Yellow", "---"));

        System.out.println((Tools.color("red",Tools.line(50))));

    }

    @Override
    public boolean exit() {
        return false;
    }
}
