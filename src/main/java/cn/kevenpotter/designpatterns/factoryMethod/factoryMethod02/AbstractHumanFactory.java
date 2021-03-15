package cn.kevenpotter.designpatterns.factoryMethod.factoryMethod02;

public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> c);
}
