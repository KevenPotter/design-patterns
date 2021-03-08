package cn.kevenpotter.designpatterns.decorator.decorator01;

import cn.kevenpotter.designpatterns.decorator.decorator01.impl.FourthGradeSchoolReport;
import cn.kevenpotter.designpatterns.decorator.decorator01.impl.HighScoreDecorator;
import cn.kevenpotter.designpatterns.decorator.decorator01.impl.SortDecorator;

public class Father {

    public static void main(String[] args) {
        SchoolReport schoolReport;
        schoolReport = new FourthGradeSchoolReport();
        schoolReport = new HighScoreDecorator(schoolReport);
        schoolReport = new SortDecorator(schoolReport);
        schoolReport.report();
        schoolReport.sign("Keven");
    }
}
