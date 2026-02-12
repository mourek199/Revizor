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
                "\n  •help/pomoc -> ukáže dostupné příkazy" +
                "\n  •lookaround/kochat se -> sdělí informace o aktualním prostředí"+
                "\n  •wait/cekej -> urychluje cestu metrem (nelze použít na stanici)" +
                "\n  •go/jdi -> nastoupí z aktuální stanice do soupravy metra" +
                "\n  •bag/batoh -> zobrazí inventář" +
                "\n  •check/kontrola -> zahájí kontrolu dokladů okolních cestujících" +
                "\n  •talk/mluv -> nabídne dostupné postavy se kterýmy lze hovořit" +
                "\n  •jump/skok -> pokus o sebevraždu" +
                "\n  •psycholog -> sdělí aktualní informace o duševním zdraví revizora" +
                "\n"+Tools.color("red", Tools.line(50));
    }

    @Override
    public boolean exit() {
        return false;
    }
}
