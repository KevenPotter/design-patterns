package cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.factory;

import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.AbstractFactory;
import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.CPUApi;
import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.MainboardApi;
import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.cpu.IntelCPU;
import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.mainboard.GAMainboard;

public class Schema1 implements AbstractFactory {

    @Override
    public CPUApi createCPUApi() {
        return new IntelCPU(1156);
    }

    @Override
    public MainboardApi createMainboardApi() {
        return new GAMainboard(1156);
    }
}
