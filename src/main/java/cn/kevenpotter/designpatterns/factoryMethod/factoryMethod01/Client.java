package cn.kevenpotter.designpatterns.factoryMethod.factoryMethod01;

import cn.kevenpotter.designpatterns.factoryMethod.factoryMethod01.impl.ExportDBOperate;

public class Client {

    public static void main(String[] args) {
        ExportOperate operate = new ExportDBOperate();
        operate.export("测试数据");
    }
}
