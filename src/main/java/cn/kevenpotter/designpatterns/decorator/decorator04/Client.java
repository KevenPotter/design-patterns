package cn.kevenpotter.designpatterns.decorator.decorator04;

import cn.kevenpotter.designpatterns.decorator.decorator04.domain.SaleModel;
import cn.kevenpotter.designpatterns.decorator.decorator04.impl.CheckDecorator;
import cn.kevenpotter.designpatterns.decorator.decorator04.impl.GoodsSaleEbo;
import cn.kevenpotter.designpatterns.decorator.decorator04.impl.LogDecorator;

public class Client {

    public static void main(String[] args) {
        GoodsSaleEbi ebi = new CheckDecorator(new LogDecorator(new GoodsSaleEbo()));
        SaleModel saleModel = new SaleModel();
        saleModel.setGoods("Moto 手机");
        saleModel.setSaleNum(2);
        ebi.sale("张三", "张三丰", saleModel);
        ebi.sale("李四", "张三丰", saleModel);
    }
}
