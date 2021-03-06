package cn.kevenpotter.designpatterns.templateMethod.templateMethod01.impl;

import cn.kevenpotter.designpatterns.templateMethod.templateMethod01.HummerModel;

public class HummerH1Model extends HummerModel {

    private boolean alarmFlag = true; // 要响喇叭

    @Override
    protected void start() {
        System.out.println("悍马H1发动");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H1停车");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H1鸣笛...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马H1引擎声是这样的...");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    // 要不要响喇叭是由客户决定的
    public void setAlarmFlag(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
}
