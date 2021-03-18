package cn.kevenpotter.designpatterns.command.command04;

import cn.kevenpotter.designpatterns.command.command04.command.ChopCommand;
import cn.kevenpotter.designpatterns.command.command04.command.DuckCommand;
import cn.kevenpotter.designpatterns.command.command04.command.MenuCommand;
import cn.kevenpotter.designpatterns.command.command04.command.WhiteMeatCommand;
import cn.kevenpotter.designpatterns.command.command04.impl.CoolCook;
import cn.kevenpotter.designpatterns.command.command04.impl.HotCook;

public class Waiter {

    private MenuCommand menuCommand = new MenuCommand();

    public void orderDish(Command command) {
        menuCommand.addCommand(command);
    }

    public void orderOver() {
        this.menuCommand.execute();
    }
}
