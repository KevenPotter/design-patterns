package cn.kevenpotter.designpatterns.decorator.decorator01.impl;

import cn.kevenpotter.designpatterns.decorator.decorator01.Decorator;
import cn.kevenpotter.designpatterns.decorator.decorator01.SchoolReport;

public class HighScoreDecorator extends Decorator {

    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportHighScore() {
        System.out.println("这次考试语文最高是92，数学是90，自然是98");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
