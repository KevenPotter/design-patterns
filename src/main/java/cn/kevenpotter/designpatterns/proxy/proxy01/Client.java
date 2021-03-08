package cn.kevenpotter.designpatterns.proxy.proxy01;

import cn.kevenpotter.designpatterns.proxy.proxy01.impl.GamePlayerProxy;

import java.util.Date;

public class Client {

    public static void main(String[] args) {
        IGamePlayer proxy = new GamePlayerProxy("张三");
        System.out.println("开始时间是: " + new Date());
        proxy.login("zhangsan", "password");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是: " + new Date());
    }
}
