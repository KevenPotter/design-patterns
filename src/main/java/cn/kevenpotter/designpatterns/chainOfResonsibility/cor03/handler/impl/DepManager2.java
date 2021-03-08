package cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.impl;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model.RequestModel;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model.impl.PreFeeRequestModel;

public class DepManager2 extends DepManager {

    @Override
    public Object handleRequest(RequestModel requestModel) {
        if (PreFeeRequestModel.FEE_TYPE.equals(requestModel.getType())) {
            return handlePreFeeRequest2(requestModel);
        } else {
            return super.handleRequest(requestModel);
        }
    }

    public Object handlePreFeeRequest2(RequestModel requestModel) {
        PreFeeRequestModel preFeeRequestModel = (PreFeeRequestModel) requestModel;
        String str = "";
        String user = preFeeRequestModel.getUser();
        double fee = preFeeRequestModel.getFee();
        if (preFeeRequestModel.getFee() < 10000) {
            System.out.println("部门经理同意" + user + "预支差旅费用" + fee + "元的请求");
            return true;
        } else {
            if (this.nextHandler != null) {
                return nextHandler.handleRequest(requestModel);
            }
        }
        return false;
    }
}
