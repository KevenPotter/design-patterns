package cn.kevenpotter.designpatterns.command.command02;

import cn.kevenpotter.designpatterns.command.command02.command.OpenCommand;
import cn.kevenpotter.designpatterns.command.command02.impl.GigaMainBoard;

public class Client {

    public static void main(String[] args) {
        MainBoardApi mainBoardApi = new GigaMainBoard();
        OpenCommand openCommand = new OpenCommand(mainBoardApi);
        Box box = new Box();
        box.setOpenCommand(openCommand);
        box.openButtonPressed();
    }
}
