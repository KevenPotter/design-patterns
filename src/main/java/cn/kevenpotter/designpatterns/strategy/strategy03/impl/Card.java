package cn.kevenpotter.designpatterns.strategy.strategy03.impl;

import cn.kevenpotter.designpatterns.strategy.strategy03.PaymentContext;
import cn.kevenpotter.designpatterns.strategy.strategy03.PaymentContext2;
import cn.kevenpotter.designpatterns.strategy.strategy03.PaymentStrategy;

public class Card implements PaymentStrategy {

    @Override
    public void pay(PaymentContext ctx) {
        PaymentContext2 ctx2 = (PaymentContext2) ctx;
        System.out.println("现在给" + ctx2.getUserName() + "的" + ctx2.getAccount() + "账号支付了" + ctx2.getMoney() + "元");
    }
}
