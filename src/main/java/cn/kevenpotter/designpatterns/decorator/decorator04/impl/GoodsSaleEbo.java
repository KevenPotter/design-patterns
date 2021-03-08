package cn.kevenpotter.designpatterns.decorator.decorator04.impl;

import cn.kevenpotter.designpatterns.decorator.decorator04.GoodsSaleEbi;
import cn.kevenpotter.designpatterns.decorator.decorator04.domain.SaleModel;

public class GoodsSaleEbo implements GoodsSaleEbi {

    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        System.out.println(user + "保存了" + customer + "购买" + saleModel + " 的销售数据");
        return true;
    }
}
