package cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.test;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.Handler;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.impl.DepManager;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.impl.GeneralManager;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.handler.impl.ProjectManager;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor03.model.impl.FeeRequestModel;

public class Client {

    public static void main(String[] args) {
        Handler projectManager = new ProjectManager();
        Handler depManager = new DepManager();
        Handler generalManager = new GeneralManager();
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
    }
}
