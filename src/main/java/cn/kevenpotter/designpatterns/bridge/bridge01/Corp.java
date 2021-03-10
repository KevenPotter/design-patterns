package cn.kevenpotter.designpatterns.bridge.bridge01;

public abstract class Corp {

    private Product product;

    public Corp(Product product) {
        this.product = product;
    }

    public void makeMoney() {
        this.product.beProduced();
        this.product.beSelled();
    }
}
