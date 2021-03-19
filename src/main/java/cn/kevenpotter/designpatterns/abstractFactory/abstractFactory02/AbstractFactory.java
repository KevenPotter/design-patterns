package cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02;

public interface AbstractFactory {

    CPUApi createCPUApi();

    MainboardApi createMainboardApi();
}
