package cn.kevenpotter.designpatterns.command.command03;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Command> undoCmds = new ArrayList<Command>();
    private List<Command> redoCmds = new ArrayList<Command>();

    private Command addCmd = null;
    private Command subCmd = null;

    public void setAddCmd(Command addCmd) {
        this.addCmd = addCmd;
    }

    public void setSubCmd(Command subCmd) {
        this.subCmd = subCmd;
    }

    public void addPressed() {
        this.addCmd.execute();
        undoCmds.add(this.addCmd);
    }

    public void subPressed() {
        this.subCmd.execute();
        undoCmds.add(this.subCmd);
    }

    public void undoPressed() {
        if (this.undoCmds.size() > 0) {
            Command cmd = this.undoCmds.get(this.undoCmds.size() - 1);
            cmd.undo();
            this.redoCmds.add(cmd);
            this.undoCmds.remove(cmd);
        } else {
            System.out.println("很抱歉，没有可撤销的命令");
        }
    }

    public void redoPressed() {
        if (this.redoCmds.size() > 0) {
            Command cmd = this.redoCmds.get(redoCmds.size() - 1);
            cmd.execute();
            this.undoCmds.add(cmd);
            this.redoCmds.remove(cmd);
        } else {
            System.out.println("很抱歉，没有可恢复的命令");
        }
    }
}
