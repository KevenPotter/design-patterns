package cn.kevenpotter.designpatterns.command.command04.impl;

import cn.kevenpotter.designpatterns.command.command04.Command;
import cn.kevenpotter.designpatterns.command.command04.CommandQueue;
import cn.kevenpotter.designpatterns.command.command04.CookApi;

public class HotCook implements CookApi, Runnable {

    // 厨师姓名
    private String name;

    public HotCook(String name) {
        this.name = name;
    }

    @Override
    public void cook(int tableNum, String name) {
        int cookTime = (int) (20 * Math.random());
        System.out.println(this.name + "厨师正在为" + tableNum + "号桌做：" + name);
        try {
            // 让线程休息这么长时间，表示正在做菜
            Thread.sleep(cookTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + "厨师为" + tableNum + "号卓做好了：" + name + "，共计耗时=" + cookTime + "秒");
    }

    @Override
    public void run() {
        while (true) {
            // 从命令队列里面获取命令对象
            Command cmd = CommandQueue.getOneCommand();
            if (cmd != null) {
                cmd.setCookApi(this);
                cmd.execute();
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
