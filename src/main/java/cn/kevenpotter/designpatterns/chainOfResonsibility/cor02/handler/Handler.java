package cn.kevenpotter.designpatterns.chainOfResonsibility.cor02.handler;

public abstract class Handler {

    protected Handler nextHandler = null;

    public void setNextHandler(Handler _nextHandler) {
        this.nextHandler = _nextHandler;
    }

    public abstract String handleFeeRequest(String user, double fee);
}
