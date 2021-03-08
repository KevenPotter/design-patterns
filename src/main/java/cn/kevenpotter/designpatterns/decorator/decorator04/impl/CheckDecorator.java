package cn.kevenpotter.designpatterns.decorator.decorator04.impl;

import cn.kevenpotter.designpatterns.decorator.decorator04.Decorator;
import cn.kevenpotter.designpatterns.decorator.decorator04.GoodsSaleEbi;
import cn.kevenpotter.designpatterns.decorator.decorator04.domain.SaleModel;

public class CheckDecorator extends Decorator {

    public CheckDecorator(GoodsSaleEbi ebi) {
        super(ebi);
    }

    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        if (!"张三".equals(user)) {
            System.out.println("对不起" + user + ", 你没有保存销售单的权限");
            return false;
        } else {
            return this.ebi.sale(user, customer, saleModel);
        }
    }
}
