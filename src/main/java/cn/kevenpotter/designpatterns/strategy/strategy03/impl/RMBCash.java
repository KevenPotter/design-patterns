package cn.kevenpotter.designpatterns.strategy.strategy03.impl;

import cn.kevenpotter.designpatterns.strategy.strategy03.PaymentContext;
import cn.kevenpotter.designpatterns.strategy.strategy03.PaymentStrategy;

public class RMBCash implements PaymentStrategy {

    @Override
    public void pay(PaymentContext ctx) {
        System.out.println("现在给" + ctx.getUserName() + "人民币现金支付" + ctx.getMoney() + "元");
    }
}
