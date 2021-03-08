package cn.kevenpotter.designpatterns.decorator.decorator02.impl;

import cn.kevenpotter.designpatterns.decorator.decorator02.Component;
import cn.kevenpotter.designpatterns.decorator.decorator02.Decorator;
import cn.kevenpotter.designpatterns.decorator.decorator02.db.TempDB;

import java.util.Date;

public class GroupPrizeDecorator extends Decorator {

    public GroupPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        double group = 0.0;
        for (double d : TempDB.mapMonthSaleMoney.values()) {
            group += d;
        }
        double prize = group * 0.01;
        System.out.println(user + "当月团队业务奖金" + prize);
        return money + prize;
    }
}
