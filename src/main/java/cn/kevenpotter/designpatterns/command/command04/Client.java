package cn.kevenpotter.designpatterns.command.command04;

import cn.kevenpotter.designpatterns.command.command04.command.ChopCommand;
import cn.kevenpotter.designpatterns.command.command04.command.DuckCommand;
import cn.kevenpotter.designpatterns.command.command04.command.WhiteMeatCommand;

public class Client {

    public static void main(String[] args) {
        // 先要启动后台，让整个程序运行起来
        CookManager.runCookManager();
        for (int i = 0; i < 5; i++) {
            Waiter waiter = new Waiter();
            Command chop = new ChopCommand(i);
            Command duck = new DuckCommand(i);
            Command meat = new WhiteMeatCommand(i);
            waiter.orderDish(chop);
            waiter.orderDish(duck);
            waiter.orderDish(meat);
            waiter.orderOver();
        }
    }
}
