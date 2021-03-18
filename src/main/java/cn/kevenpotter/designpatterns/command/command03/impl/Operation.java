package cn.kevenpotter.designpatterns.command.command03.impl;

import cn.kevenpotter.designpatterns.command.command03.OperationApi;

public class Operation implements OperationApi {

    // 记录运算的结果
    private int result;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public void add(int num) {
        result += num;
    }

    @Override
    public void sub(int num) {
        result -= num;
    }
}
