package cn.kevenpotter.designpatterns.strategy.strategy02;

import java.util.Arrays;

public class Client {

    public final static String ADD_SYMBOL = "+";
    public final static String SUB_SYMBOL = "-";

    public static void main(String[] args) {
        String[] cals = {"1", "-", "2"};
        int a = Integer.parseInt(cals[0]);
        String symbol = cals[1];
        int b = Integer.parseInt(cals[2]);
        System.out.println("输入的参数为: " + Arrays.toString(cals));
        if (symbol.equals(ADD_SYMBOL)) {
            System.out.println("运行结果为: " + a + symbol + b + "=" + Calculator.ADD.exec(a, b));
        } else if (symbol.equals(SUB_SYMBOL)) {
            System.out.println("运行结果为: " + a + symbol + b + "=" + Calculator.SUB.exec(a, b));
        }
    }
}
