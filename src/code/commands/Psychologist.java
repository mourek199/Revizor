package code.commands;

import code.Revizor;
import code.Tools;

/**
 * Command used to tell status and heal depression
 */
public class Psychologist extends Command {
    private Revizor revizor;

    /**
     *Reviews player's depression state depending on depression value
     */
    @Override
    public String execute() {
        Tools.consoleClear();
        System.out.print("Shrnutí: ");
        if (revizor.getDepression() <= 5){
            return "Tvůj mentální stav " + Tools.color("green", "není vážný ")
                    +"(aktuální stav deprese = " + Tools.color("green", String.valueOf(revizor.getDepression())) + ")";
        }
        if (revizor.getDepression() > 5 && revizor.getDepression() <= 10){
            return "Tvůj mentální stav " + Tools.color("yellow", "je lehce znepokojující ")
                    +"(aktuální stav deprese = " + Tools.color("yellow", String.valueOf(revizor.getDepression())) + ")";
        }
        if (revizor.getDepression() > 10 && revizor.getDepression() <= 30){
            return "Tvůj mentální stav " + Tools.color("red", "je silně znepokojující ")
                    +"(aktuální stav deprese = " + Tools.color("red", String.valueOf(revizor.getDepression())) + ")";
        }
        else return "Vyšetření a tenhle celej program pravděpodobně selhaly "
                +"(aktuální stav deprese = " + Tools.color("purple", "AŽ MOC"+ ")");
    }

    @Override
    public boolean exit() {
        return false;
    }

    public Psychologist(code.Revizor revizor) {
        this.revizor = revizor;
    }
}
