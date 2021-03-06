package cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler.impl;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.handler.Handler;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.women.IWomen;

public class Son extends Handler {

    public Son() {
        super(Handler.SON_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("------- 母亲向儿子请示 -------");
        System.out.println(women.getRequest());
        System.out.println("------- 儿子的答复是: 同意 -------");
    }
}
