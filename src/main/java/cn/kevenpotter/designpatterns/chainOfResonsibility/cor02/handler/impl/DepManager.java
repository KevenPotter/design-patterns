package cn.kevenpotter.designpatterns.chainOfResonsibility.cor02.handler.impl;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor02.handler.Handler;

public class DepManager extends Handler {

    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        if (fee < 1000) {
            if ("小李".equals(user)) str = "部门经理同意" + user + "聚餐费用" + fee + "元的请求";
            else str = "部门经理不同意" + user + "聚餐费用" + fee + "元的请求";
            return str;
        } else {
            if (this.nextHandler != null) {
                return nextHandler.handleFeeRequest(user, fee);
            }
        }
        return str;
    }
}
