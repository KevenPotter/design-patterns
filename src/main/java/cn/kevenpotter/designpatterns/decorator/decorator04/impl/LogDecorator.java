package cn.kevenpotter.designpatterns.decorator.decorator04.impl;

import cn.kevenpotter.designpatterns.decorator.decorator04.Decorator;
import cn.kevenpotter.designpatterns.decorator.decorator04.GoodsSaleEbi;
import cn.kevenpotter.designpatterns.decorator.decorator04.domain.SaleModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogDecorator extends Decorator {

    public LogDecorator(GoodsSaleEbi ebi) {
        super(ebi);
    }

    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        boolean f = this.ebi.sale(user, customer, saleModel);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("日志记录: " + user + "于" + dateFormat.format(new Date()) + "时保存了一条销售记录, 客户是" + customer + ",购买记录是" + saleModel);
        return f;
    }
}
