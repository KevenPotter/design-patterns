package cn.kevenpotter.designpatterns.bridge.bridge01.impl.corp;

import cn.kevenpotter.designpatterns.bridge.bridge01.Corp;
import cn.kevenpotter.designpatterns.bridge.bridge01.Product;

public class ShanZhaiCorp extends Corp {

    public ShanZhaiCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱呀...");
    }
}
