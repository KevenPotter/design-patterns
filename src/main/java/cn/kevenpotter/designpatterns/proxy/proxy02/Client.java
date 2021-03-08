package cn.kevenpotter.designpatterns.proxy.proxy02;

import cn.kevenpotter.designpatterns.proxy.proxy02.impl.GamePlayer;
import cn.kevenpotter.designpatterns.proxy.proxy02.impl.GamePlayerProxy;

import java.util.Date;

public class Client {

    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");
        IGamePlayer proxy = player.getProxy();
        System.out.println("开始时间是: " + new Date());
        proxy.login("zhangsan", "password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是: " + new Date());
    }
}
