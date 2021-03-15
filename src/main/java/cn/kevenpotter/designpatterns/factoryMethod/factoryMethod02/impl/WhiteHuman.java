package cn.kevenpotter.designpatterns.factoryMethod.factoryMethod02.impl;

import cn.kevenpotter.designpatterns.factoryMethod.factoryMethod02.Human;

public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("白色人种的皮肤白黑色的!");
    }

    @Override
    public void talk() {
        System.out.println("白色人种会说话, 一般说的都是单字节.");
    }
}
