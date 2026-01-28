package code.commands;

import code.Revizor;

public class Suicide extends Command {

    private Revizor revizor;

    @Override
    public String execute() {
        if (exit() == true){
            return "you krilled yourself";
        } else return "i should listen to DPP policies.";
    }

    @Override
    public boolean exit() {
        if (revizor.getDepression() > 30){
            return true;
        } else return false;
    }

    public Suicide(code.Revizor revizor){
        this.revizor = revizor;
    }
}
