package cn.kevenpotter.designpatterns.command.command04.command;

import cn.kevenpotter.designpatterns.command.command04.Command;
import cn.kevenpotter.designpatterns.command.command04.CookApi;

import java.util.ArrayList;
import java.util.Collection;

public class MenuCommand implements Command {

    private Collection<Command> collection = new ArrayList<Command>();

    public void addCommand(Command command) {
        this.collection.add(command);
    }

    @Override
    public void setCookApi(CookApi cookApi) {

    }

    @Override
    public int getTableNum() {
        return 0;
    }

    public Collection<Command> getCommands() {
        return this.collection;
    }

    @Override
    public void execute() {
        for (Command command : collection) {
            command.execute();
        }
    }
}
