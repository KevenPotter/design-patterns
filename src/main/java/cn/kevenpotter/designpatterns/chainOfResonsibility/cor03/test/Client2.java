package cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.test;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.Handler;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.impl.DepManager2;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.impl.GeneralManager2;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.impl.ProjectManager2;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model.impl.FeeRequestModel;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model.impl.PreFeeRequestModel;

public class Client2 {

    public static void main(String[] args) {
        Handler projectManager = new ProjectManager2();
        Handler depManager = new DepManager2();
        Handler generalManager = new GeneralManager2();
        projectManager.setNextHandler(depManager);
        depManager.setNextHandler(generalManager);

        FeeRequestModel feeRequestModel = new FeeRequestModel();
        feeRequestModel.setUser("小李");
        feeRequestModel.setFee(300);
        String ret1 = (String) projectManager.handleRequest(feeRequestModel);
        System.out.println("ret1: " + ret1);
        System.out.println();

        feeRequestModel.setFee(800);
        String ret2 = (String) projectManager.handleRequest(feeRequestModel);
        System.out.println("ret2: " + ret2);
        System.out.println();

        feeRequestModel.setFee(1600);
        String ret3 = (String) projectManager.handleRequest(feeRequestModel);
        System.out.println("ret3: " + ret3);
        System.out.println();

        PreFeeRequestModel preFeeRequestModel = new PreFeeRequestModel();
        preFeeRequestModel.setUser("小张");
        preFeeRequestModel.setFee(3000);
        projectManager.handleRequest(preFeeRequestModel);
        System.out.println();

        preFeeRequestModel.setFee(6000);
        projectManager.handleRequest(preFeeRequestModel);
        System.out.println();

        preFeeRequestModel.setFee(360000);
        projectManager.handleRequest(preFeeRequestModel);
    }
}
