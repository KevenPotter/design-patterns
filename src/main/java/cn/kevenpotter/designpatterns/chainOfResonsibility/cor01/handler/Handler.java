package cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.women.IWomen;

public abstract class Handler {

    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    private int level = 0;          // 能处理的级别
    private Handler nextHandler;    // 责任传递，下一个人责任人是谁

    public Handler(int _level) {    // 每个类都要说明一下自己能处理那些请求
        this.level = _level;
    }

    public final void handleMessage(IWomen women) {  // 一个女性(女儿、妻子或者是母亲)要求逛街，你要处理这个请求
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHandler != null) {          // 有后续环节, 才把请求往后递送
                this.nextHandler.handleMessage(women);
            } else {
                System.out.println("--- 没地方请示了, 按不同意处理 ---");
            }
        }
    }

    /**
     * 如果不属于你处理的请求，你应该让她找下一个环节的人，如女儿出嫁了，还像父亲请示是否可以狂街，那父亲就应该告诉女儿，应该找丈夫请示
     */
    public void setNext(Handler _handler) {
        this.nextHandler = _handler;
    }

    protected abstract void response(IWomen women); // 有请示那当然要回应
}