package cn.kevenpotter.designpatterns.strategy.strategy03;

public interface PaymentStrategy {

    /**
     * 公司给某人真正支付工资
     *
     * @param ctx 支付工资的上下文，里面包含算法需要的数据
     */
    void pay(PaymentContext ctx);
}
