package code.commands;

import code.Revizor;

public class Suicide extends Command {

    private Revizor revizor;

    @Override
    public String execute() {
        if(!revizor.getCurrentLocation().getName().equalsIgnoreCase("metro")){
            if (exit()){
                return "hop! ndjfkjdsnfkndsfnsiofndfn (You krilled yourself)";
            } else return "Hm.. To by bylo zajímavý no, ale nemůžu skočit pod metro.. to nám v DPP přísně zakázali";
        }else {
            return  "Asi jen težko budu skákat pod koleje zevnitř metra...";
        }
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
