package cn.kevenpotter.designpatterns.bridge.bridge01.impl.corp;

import cn.kevenpotter.designpatterns.bridge.bridge01.Corp;
import cn.kevenpotter.designpatterns.bridge.bridge01.Product;
import cn.kevenpotter.designpatterns.bridge.bridge01.impl.product.House;

public class HouseCorp extends Corp {

    public HouseCorp(House house) {
        super(house);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了...");
    }
}
