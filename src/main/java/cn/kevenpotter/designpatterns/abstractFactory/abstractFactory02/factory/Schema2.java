package cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.factory;

import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.AbstractFactory;
import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.CPUApi;
import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.MainboardApi;
import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.cpu.AMDCPU;
import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.mainboard.MSIMainboard;

public class Schema2 implements AbstractFactory {
    @Override
    public CPUApi createCPUApi() {
        return new AMDCPU(939);
    }

    @Override
    public MainboardApi createMainboardApi() {
        return new MSIMainboard(939);
    }
}
