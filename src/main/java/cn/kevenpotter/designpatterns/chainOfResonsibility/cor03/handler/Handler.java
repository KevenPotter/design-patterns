package cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model.RequestModel;

public abstract class Handler {

    protected Handler nextHandler = null;

    public void setNextHandler(Handler _nextHandler) {
        this.nextHandler = _nextHandler;
    }

    public Object handleRequest(RequestModel requestModel) {
        if (nextHandler != null) {
            return this.nextHandler.handleRequest(requestModel);
        } else {
            System.out.println("没有后续处理或者暂时不支持这样的功能处理");
            return false;
        }
    }
}
