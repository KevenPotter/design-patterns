package cn.kevenpotter.designpatterns.strategy.strategy03;

import cn.kevenpotter.designpatterns.strategy.strategy03.impl.Card;
import cn.kevenpotter.designpatterns.strategy.strategy03.impl.DollarCash;
import cn.kevenpotter.designpatterns.strategy.strategy03.impl.RMBCash;

public class Client {

    public static void main(String[] args) {
        PaymentStrategy strategyRMB = new RMBCash();
        PaymentStrategy strategyDollar = new DollarCash();
        PaymentContext ctx1 = new PaymentContext("小李", 5000, strategyRMB);
        ctx1.payNow();
        PaymentContext ctx2 = new PaymentContext("Petter", 8000, strategyDollar);
        ctx2.payNow();
        PaymentStrategy strategyCard = new Card();
        PaymentContext ctx3 = new PaymentContext2("小王", 9000, "010998877656", strategyCard);
        ctx3.payNow();
    }
}
