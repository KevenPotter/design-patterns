package cn.kevenpotter.designpatterns.factoryMethod.factoryMethod02.impl;

import cn.kevenpotter.designpatterns.factoryMethod.factoryMethod02.AbstractHumanFactory;
import cn.kevenpotter.designpatterns.factoryMethod.factoryMethod02.Human;

public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人种生成错误! ");
        }
        return (T) human;
    }
}
