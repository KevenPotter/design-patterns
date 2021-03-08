package cn.kevenpotter.designpatterns.decorator.decorator02.db;

import java.util.HashMap;
import java.util.Map;

public class TempDB {

    private TempDB() {
    }

    public static Map<String, Double> mapMonthSaleMoney = new HashMap<String, Double>();

    static {
        mapMonthSaleMoney.put("张三", 10000.0);
        mapMonthSaleMoney.put("李四", 20000.0);
        mapMonthSaleMoney.put("王五", 30000.0);
    }
}
