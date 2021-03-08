package cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.impl;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.Handler;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model.RequestModel;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model.impl.FeeRequestModel;

public class DepManager extends Handler {

    @Override
    public Object handleRequest(RequestModel requestModel) {
        if (FeeRequestModel.FEE_TYPE.equals(requestModel.getType())) {
            return handleFeeRequest(requestModel);
        } else {
            return super.handleRequest(requestModel);
        }
    }

    public Object handleFeeRequest(RequestModel requestModel) {
        FeeRequestModel feeRequestModel = (FeeRequestModel) requestModel;
        String str = "";
        String user = feeRequestModel.getUser();
        double fee = feeRequestModel.getFee();
        if (fee < 1000) {
            if ("小李".equals(user)) str = "部门经理同意" + user + "聚餐费用" + fee + "元的请求";
            else str = "部门经理不同意" + user + "聚餐费用" + fee + "元的请求";
            return str;
        } else {
            if (this.nextHandler != null) {
                return nextHandler.handleRequest(requestModel);
            }
        }
        return str;
    }
}
