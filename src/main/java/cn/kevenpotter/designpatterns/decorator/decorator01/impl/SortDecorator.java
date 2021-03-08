package cn.kevenpotter.designpatterns.decorator.decorator01.impl;

import cn.kevenpotter.designpatterns.decorator.decorator01.Decorator;
import cn.kevenpotter.designpatterns.decorator.decorator01.SchoolReport;

public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportSort() {
        System.out.println("KevenPotter是排名第2名...");
    }

    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
