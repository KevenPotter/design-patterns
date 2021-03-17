package cn.kevenpotter.designpatterns.command.command01.command;

import cn.kevenpotter.designpatterns.command.command01.Command;

public class DeletePageCommand extends Command {

    @Override
    public void execute() {
        super.pg.find();
        super.pg.delete();
        super.pg.plan();
    }
}
