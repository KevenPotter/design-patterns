package cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02;

import cn.kevenpotter.designpatterns.abstractFactory.abstractFactory02.factory.Schema1;

public class Client {

    public static void main(String[] args) {
        ComputerEngineer engineer = new ComputerEngineer();
        AbstractFactory schema = new Schema1();
        engineer.makeComputer(schema);
    }
}
