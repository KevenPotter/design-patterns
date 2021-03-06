package cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler.impl;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler.Handler;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.women.IWomen;

public class Father extends Handler {

    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("------- 女儿向父亲请示 -------");
        System.out.println(women.getRequest());
        System.out.println("------- 父亲的答复是: 同意 -------");
    }
}
