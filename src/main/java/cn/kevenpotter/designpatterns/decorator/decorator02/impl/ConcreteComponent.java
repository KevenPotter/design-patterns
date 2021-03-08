package cn.kevenpotter.designpatterns.decorator.decorator02.impl;

import cn.kevenpotter.designpatterns.decorator.decorator02.Component;

import java.util.Date;

public class ConcreteComponent extends Component {

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        return 0;       // 知识一个默认的实现，默认没有奖金
    }
}
