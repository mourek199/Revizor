package code;

import java.util.Scanner;

public class Tools {

    static Scanner sc = new Scanner(System.in);

    /**
     * returns ANSI code for colorful console prints based on color name
     * @param color color name
     * @return ANSI code for the chosen color
     */
    public static String color(String color) {
        return switch (color.toUpperCase()) {
            case "BLACK" -> "\u001B[30m";
            case "RED" -> "\u001B[31m";
            case "GREEN" -> "\u001B[32m";
            case "YELLOW" -> "\u001B[33m";
            case "BLUE" -> "\u001B[34m";
            case "PURPLE" -> "\u001B[35m";
            case "CYAN" -> "\u001B[36m";
            case "WHITE" -> "\u001B[37m";
            default -> "\u001B[0m";
        };
    }

    /**
     * prints a string by printing each character individually
     * @param text a string you want to print
     * @param speed defines how long does the method wait before printing next character
     */
    public static void charPrint(String text, int speed){
        String[] individualCharacters = text.split("");
        for (int i = 0; i < individualCharacters.length; i++) {
            System.out.print(individualCharacters[i]);
            freeze(speed);
        }
    }

    /**
     * freezes the game for specified time
     * @param howLong defines freezed time
     */
    public static void freeze(int howLong){
        try {
            Thread.sleep(howLong);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *waits until enter key is pressed
     */
    public static void pressEnter(){
        System.out.print("Pro pokračování stiskni " + color("blue", "Enter"));
        sc.nextLine();
    }

    /**
     * used to quickly print a yes/no question
     * @return colorful parentheses
     */
    public static String yesNo (){
        return "(" + color("green", "A") + "/" + color("red", "N") + ")";
    }

    /**
     * Yells at you for not being able to choose from a dialog window
     */
    public static void invalidInput(){
        System.out.println(Tools.color("red", "NEPLATNÝ VSTUP, PROSÍM ZKUS TO ZNOVU"));
    }

    /**
     * prints blank lines in order to achieve an illusion of cleared console
     */
    public static void consoleClear(){
        lineSkip(70);
    }

    /**
     * prints a specified amount of blank lines
     * @param numberOfLines how many blank lines
     */
    public static void lineSkip(int numberOfLines) {
        System.out.print("\n".repeat(numberOfLines));
    }

    /**
     *
     * @param lineLength defines length of a line
     * @return String representation of a line
     */
    public static String line(int lineLength) {
        return "_".repeat(lineLength);
    }

    /**
     * similar to line method but this one prints the line
     * @param lineLength defines length of a line
     */
    public static void linePrint(int lineLength){
        System.out.println(Tools.line(lineLength));
    }

    /**
     * Yells at you for trying to use a command when it's not possible
     * @return
     */
    public static String unAvailableCommand(){
        consoleClear();
        return color("red", "TENTO PŘÍKAZ TEĎ NELZE POUŽÍT (Napiš \"help\" pro pomoc s příkazy)");
    }

    /**
     * expanded variant of the method color, that sets the color only for the given string
     * used for colorful console prints
     *
     * @param color color name
     * @param str string which is colored
     * @return color code, colorful text and default color code
     */

    public static String color(String color, String str) {
        return color(color) + str + color("default");
    }
}
