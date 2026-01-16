package code.commands;

import code.Command;

public class Suicide implements Command {
    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
