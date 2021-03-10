package cn.kevenpotter.designpatterns.strategy.strategy01;

import java.util.Arrays;

public class Client {

    public final static String ADD_SYMBOL = "+";
    public final static String SUB_SYMBOL = "-";

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);
        System.out.println("输入的参数为: " + Arrays.toString(args));
    }
}
