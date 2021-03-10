package cn.kevenpotter.designpatterns.bridge.bridge01.impl.product;

import cn.kevenpotter.designpatterns.bridge.bridge01.Product;

public class IPod extends Product {

    @Override
    public void beProduced() {
        System.out.println("生产书的iPod是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的iPod卖出去了...");
    }
}
