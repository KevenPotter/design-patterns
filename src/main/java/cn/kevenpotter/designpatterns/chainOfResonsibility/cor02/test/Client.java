package cn.kevenpotter.designpatterns.chainOfResonsibility.cor02.test;

import cn.kevenpotter.designpatterns.chainOfResonsibility.cor02.handler.Handler;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor02.handler.impl.DepManager;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor02.handler.impl.GeneralManager;
import cn.kevenpotter.designpatterns.chainOfResonsibility.cor02.handler.impl.ProjectManager;

public class Client {

    public static void main(String[] args) {
        Handler projectManager = new ProjectManager();
        Handler depManager = new DepManager();
        Handler generalManager = new GeneralManager();
        projectManager.setNextHandler(depManager);
        depManager.setNextHandler(generalManager);
        String ret1 = projectManager.handleFeeRequest("小李", 300);
        System.out.println("the ret1: " + ret1);
        String ret2 = projectManager.handleFeeRequest("小张", 300);
        System.out.println("the ret2: " + ret2);
        System.out.println();
        String ret3 = projectManager.handleFeeRequest("小李", 600);
        System.out.println("the ret3: " + ret3);
        String ret4 = projectManager.handleFeeRequest("小张", 600);
        System.out.println("the ret4: " + ret4);
        System.out.println();
        String ret5 = projectManager.handleFeeRequest("小李", 1200);
        System.out.println("the ret5: " + ret5);
        String ret6 = projectManager.handleFeeRequest("小张", 1200);
        System.out.println("the ret6: " + ret6);
    }
}
