package cn.kevenpotter.designpatterns.command.command03;

import cn.kevenpotter.designpatterns.command.command03.command.AddCommand;
import cn.kevenpotter.designpatterns.command.command03.command.SubCommand;
import cn.kevenpotter.designpatterns.command.command03.impl.Operation;

public class Client {

    public static void main(String[] args) {
        OperationApi operationApi = new Operation();
        AddCommand addCommand = new AddCommand(operationApi, 5);
        SubCommand subCommand = new SubCommand(operationApi, 3);
        Calculator calculator = new Calculator();
        calculator.setAddCmd(addCommand);
        calculator.setSubCmd(subCommand);
        calculator.addPressed();
        System.out.println("一次加法运算后的结果为：" + operationApi.getResult());
        calculator.subPressed();
        System.out.println("一次减法运算后的结果为：" + operationApi.getResult());
        calculator.undoPressed();
        System.out.println("撤销一次后的结果为：" + operationApi.getResult());
        calculator.undoPressed();
        System.out.println("再撤销一次后的结果为：" + operationApi.getResult());
        calculator.redoPressed();
        System.out.println("恢复操作一次后的结果为：" + operationApi.getResult());
        calculator.redoPressed();
        System.out.println("再恢复操作一次后的结果为：" + operationApi.getResult());
    }
}
