package cn.kevenpotter.designpatterns.decorator.decorator01.impl;

import cn.kevenpotter.designpatterns.decorator.decorator01.SchoolReport;

public class FourthGradeSchoolReport extends SchoolReport {

    @Override
    public void report() {
        System.out.println("尊敬的KevenPotter家长：");
        System.out.println("   ......");
        System.out.println("语文 90  数学 90  体育  100  自然 98");
        System.out.println("   ......");
        System.out.println("                        家长签名:       ");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名为: " + name);
    }
}
