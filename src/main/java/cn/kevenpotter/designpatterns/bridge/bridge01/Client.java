package cn.kevenpotter.designpatterns.bridge.bridge01;

import cn.kevenpotter.designpatterns.bridge.bridge01.impl.corp.HouseCorp;
import cn.kevenpotter.designpatterns.bridge.bridge01.impl.corp.ShanZhaiCorp;
import cn.kevenpotter.designpatterns.bridge.bridge01.impl.product.House;
import cn.kevenpotter.designpatterns.bridge.bridge01.impl.product.IPod;

public class Client {

    public static void main(String[] args) {
        System.out.println("-------房地产公司是这样运行的-------");
        HouseCorp houseCorp = new HouseCorp(new House());
        houseCorp.makeMoney();
        System.out.println();
        System.out.println("-------山寨公司是这样运行的-------");
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();
    }
}
