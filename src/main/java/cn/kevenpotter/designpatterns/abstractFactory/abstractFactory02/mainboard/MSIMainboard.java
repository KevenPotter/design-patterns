package cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.mainboard;

import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.MainboardApi;

public class MSIMainboard implements MainboardApi {

    private int cpuHoles = 0;

    public MSIMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("now in MSIMainboard,cpuHoles=" + cpuHoles);
    }
}
