package cn.kevenpotter.designpatterns.command.command01.command;

import cn.kevenpotter.designpatterns.command.command01.Command;

public class AddRequirementCommand extends Command {

    @Override
    public void execute() {
        super.rg.find();
        super.rg.add();
        super.rg.plan();
    }
}
