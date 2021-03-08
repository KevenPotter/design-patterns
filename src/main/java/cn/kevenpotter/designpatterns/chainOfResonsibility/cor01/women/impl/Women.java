package cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.women.impl;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor01.women.IWomen;

public class Women implements IWomen {

    /**
     * 通过一个int类型的参数来描述妇女的个人情况
     * 1--未出嫁
     * 2--出家
     * 3--丧夫
     */
    private int type = 0;

    /**
     * 妇女的请示
     */
    private String request = "";

    /**
     * 构造函数传递过来请求
     */
    public Women(int _type, String _request) {
        this.type = _type;
        switch (this.type) {
            case 1:
                this.request = "女儿的请求是: " + _request;
                break;
            case 2:
                this.request = "妻子的请求是: " + _request;
                break;
            case 3:
                this.request = "母亲的请求是: " + _request;
        }
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
