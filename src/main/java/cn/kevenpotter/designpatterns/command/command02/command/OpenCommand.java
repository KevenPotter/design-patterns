package cn.kevenpotter.designpatterns.command.command02.command;

import cn.kevenpotter.designpatterns.command.command02.Command;
import cn.kevenpotter.designpatterns.command.command02.MainBoardApi;

public class OpenCommand implements Command {

    // 持有真正实现命令的接收者——主板对象
    private MainBoardApi mainBoardApi = null;

    // 构造方法，传入主板对象
    public OpenCommand(MainBoardApi mainBoardApi) {
        this.mainBoardApi = mainBoardApi;
    }

    @Override
    public void execute() {
        this.mainBoardApi.open();
    }
}
