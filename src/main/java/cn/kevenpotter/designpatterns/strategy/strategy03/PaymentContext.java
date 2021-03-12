package cn.kevenpotter.designpatterns.strategy.strategy03;

public class PaymentContext {

    private String userName = null;
    private double money = 0.0;
    private PaymentStrategy paymentStrategy = null;

    public PaymentContext(String userName, double money, PaymentStrategy paymentStrategy) {
        this.userName = userName;
        this.money = money;
        this.paymentStrategy = paymentStrategy;
    }

    public String getUserName() {
        return userName;
    }

    public double getMoney() {
        return money;
    }

    public void payNow() {
        this.paymentStrategy.pay(this);
    }
}
