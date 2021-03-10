package cn.kevenpotter.designpatterns.strategy.strategy01.impl;

import cn.kevenpotter.designpatterns.strategy.strategy01.Calculator;

public class Add implements Calculator {

    @Override
    public int exec(int a, int b) {
        return a + b;
    }
}
