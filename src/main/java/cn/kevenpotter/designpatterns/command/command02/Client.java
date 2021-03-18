package cn.kevenpotter.designpatterns.command.command02;

import cn.kevenpotter.designpatterns.command.command02.command.OpenCommand;
import cn.kevenpotter.designpatterns.command.command02.command.ResetCommand;
import cn.kevenpotter.designpatterns.command.command02.impl.GigaMainBoard;

public class Client {

    public static void main(String[] args) {
        MainBoardApi mainBoardApi = new GigaMainBoard();
        OpenCommand openCommand = new OpenCommand(mainBoardApi);
        ResetCommand resetCommand = new ResetCommand(mainBoardApi);
        Box box = new Box();
        box.setOpenCommand(openCommand);
        box.setResetCommand(resetCommand);
        System.out.println("正确配置下--------------");
        System.out.println(">>>按下开机按钮：>>>");
        box.openButtonPressed();
        System.out.println("<<<按下重启按钮：<<<");
        box.resetButtonPressed();
        System.out.println("错误正确配置下--------------");
        System.out.println(">>>按下开机按钮：>>>");
        box.resetButtonPressed();
        System.out.println("<<<按下重启按钮：<<<");
        box.openButtonPressed();

    }
}
