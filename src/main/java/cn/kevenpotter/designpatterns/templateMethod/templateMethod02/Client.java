package cn.kevenpotter.designpatterns.templateMethod.templateMethod02;

import cn.kevenpotter.designpatterns.templateMethod.templateMethod02.impl.NormalLogin;
import cn.kevenpotter.designpatterns.templateMethod.templateMethod02.impl.WorkerLogin;
import cn.kevenpotter.designpatterns.templateMethod.templateMethod02.model.LoginModel;

public class Client {

    public static void main(String[] args) {
        // 准备登陆人的信息
        LoginModel lm = new LoginModel();
        lm.setLoginId("admin");
        lm.setPwd("workerpwd");
        LoginTemplate lt = new WorkerLogin();
        LoginTemplate lt2 = new NormalLogin();
        boolean flag = lt.login(lm);
        System.out.println("可以登录工作平台" + flag);
        boolean flag2 = lt2.login(lm);
        System.out.println("可以进行普通人员登录" + flag2);
    }
}
