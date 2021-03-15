package cn.kevenpotter.designpatterns.factoryMethod.factoryMethod02.impl;

import cn.kevenpotter.designpatterns.factoryMethod.factoryMethod02.Human;

public class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("黑色人种的皮肤是黑色的!");
    }

    @Override
    public void talk() {
        System.out.println("黑色人种会说话, 一般听不懂.");
    }
}
