package code.commands;

import code.Tools;

public class Help extends Command {

    public Help() {
    }

    @Override
    public String execute() {
        Tools.consoleClear();

        return Tools.color("red", Tools.line(50))+
                "\nDostupné příkazy:" +
                "\n  •help -> ukáže dostupné příkazy" +
                "\n  •lookaround -> sdělí informace o aktualním prostředí"+
                "\n  •cekej -> urychluje cestu metrem (nelze použít na stanici)" +
                "\n  •jdi -> nastoupí z aktuální stanice do soupravy metra" +
                "\n  •batoh -> zobrazí inventář" +
                "\n  •skok -> pokus o sebevraždu" +
                "\n  •psycholog -> sdělí aktualní informace o duševním zdraví revizora" +
                "\n"+Tools.color("red", Tools.line(50));
    }

    @Override
    public boolean exit() {
        return false;
    }
}
