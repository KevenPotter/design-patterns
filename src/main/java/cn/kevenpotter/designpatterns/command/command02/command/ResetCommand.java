package cn.kevenpotter.designpatterns.command.command02.command;

import cn.kevenpotter.designpatterns.command.command02.Command;
import cn.kevenpotter.designpatterns.command.command02.MainBoardApi;

public class ResetCommand implements Command {

    // 持有真正实现命令的接收者——主板对象
    private MainBoardApi mainBoardApi = null;

    // 构造方法，传入主板对象
    public ResetCommand(MainBoardApi mainBoardApi) {
        this.mainBoardApi = mainBoardApi;
    }

    @Override
    public void execute() {
        // 对于命令对象，根本不知道如何重启机器，会转调主板对象
        // 让主板去完成重启机器的功能
        this.mainBoardApi.reset();
    }
}
