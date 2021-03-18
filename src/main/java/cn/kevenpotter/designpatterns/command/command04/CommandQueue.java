package cn.kevenpotter.designpatterns.command.command04;

import cn.kevenpotter.designpatterns.command.command04.command.MenuCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {

    // 用来存储命令对象的队列
    private static List<Command> cmds = new ArrayList<Command>();

    /**
     * 服务员传过来一个新的菜单，需要同步
     * 因为同时会有很多的服务员传入菜单，而同时又有很多厨师在从队列里取值
     */
    public synchronized static void addMenu(MenuCommand menu) {
        for (Command cmd : menu.getCommands()) {
            cmds.add(cmd);
        }
    }

    /**
     * 厨师从命令队列里面获取命令对象进行处理，也是需要同步的
     */
    public synchronized static Command getOneCommand() {
        Command cmd = null;
        if (cmds.size() > 0) {
            cmd = cmds.get(0);
            cmds.remove(0);
        }
        return cmd;
    }
}
