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

    public static void pressEnter(){
        System.out.print("Pro pokračování stiskni " + color("blue", "Enter"));
        sc.nextLine();
    }

    public static String yesNo (){
        return "(" + color("green", "Y") + "/" + color("red", "N") + ")";
    }

    public static void invalidInput(){
        System.out.println(Tools.color("red", "NEPLATNÝ VSTUP, PROSÍM ZKUS TO ZNOVU"));
    }

    public static void consoleClear(){
        lineSkip(70);
    }

    public static void lineSkip(int numberOfLines) {
        System.out.print("\n".repeat(numberOfLines));
    }

    public static String line(int lineLength) {
        return "_".repeat(lineLength);
    }

    public static void linePrint(int lineLength){
        System.out.println(Tools.line(lineLength));
    }

    public static String unAvailableCommand(){
        consoleClear();
        return color("red", "TENTO PŘÍKAZ TEĎ NELZE POUŽÍT");
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
