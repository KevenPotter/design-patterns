package cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.cpu;

import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.CPUApi;

public class IntelCPU implements CPUApi {

    private int pins = 0;

    public IntelCPU(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("nwo in Intel CPU, pins = " + pins);
    }
}
