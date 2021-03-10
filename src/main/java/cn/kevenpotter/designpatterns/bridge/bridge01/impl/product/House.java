package cn.kevenpotter.designpatterns.bridge.bridge01.impl.product;

import cn.kevenpotter.designpatterns.bridge.bridge01.Product;

public class House extends Product {

    @Override
    public void beProduced() {
        System.out.println("生产出的房子是这样的...");
    }

    @Override
    public void beSelled() {
        System.out.println("生产出的房子卖出去了...");
    }
}
