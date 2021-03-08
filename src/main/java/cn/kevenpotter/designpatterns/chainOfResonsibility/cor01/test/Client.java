package cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.test;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler.Handler;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler.impl.Father;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler.impl.Husband;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler.impl.Son;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.women.IWomen;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.women.impl.Women;

import java.util.ArrayList;
import java.util.Random;

public class Client {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(random.nextInt(4), "我要出去逛街"));
        }
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        father.setNext(husband);
        husband.setNext(son);
        for (IWomen women : arrayList) {
            father.handleMessage(women);
            System.out.println();
        }
    }
}
