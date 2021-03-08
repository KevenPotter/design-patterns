package cn.kevenpotter.designpatterns.decorator.decorator02.impl;

import cn.kevenpotter.designpatterns.decorator.decorator02.Component;
import cn.kevenpotter.designpatterns.decorator.decorator02.Decorator;
import cn.kevenpotter.designpatterns.decorator.decorator02.db.TempDB;

import java.util.Date;

public class MonthPrizeDecorator extends Decorator {

    public MonthPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user + "当月业务奖金" + prize);
        return money + prize;
    }
}
