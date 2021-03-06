package cn.kevenpotter.designpatterns.strategy.strategy01;

import cn.kevenpotter.designpatterns.strategy.strategy01.impl.Add;
import cn.kevenpotter.designpatterns.strategy.strategy01.impl.Sub;

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
        Context context = null;
        if (symbol.equals(ADD_SYMBOL)) {
            context = new Context(new Add());
        } else if (symbol.equals(SUB_SYMBOL)) {
            context = new Context(new Sub());
        }
        System.out.println("运行结果为: " + a + symbol + b + "=" + context.exec(a, b, symbol));
    }
}
