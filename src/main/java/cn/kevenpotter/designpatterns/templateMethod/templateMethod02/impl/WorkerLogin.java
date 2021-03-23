package cn.kevenpotter.designpatterns.templateMethod.templateMethod02.impl;

import cn.kevenpotter.designpatterns.templateMethod.templateMethod02.LoginTemplate;
import cn.kevenpotter.designpatterns.templateMethod.templateMethod02.model.LoginModel;

public class WorkerLogin extends LoginTemplate {

    @Override
    public LoginModel findLoginUser(String loginId) {
        LoginModel lm = new LoginModel();
        lm.setLoginId(loginId);
        lm.setPwd("workerpwd");
        return lm;
    }

    @Override
    public String encryptPwd(String pwd) {
        /*
         * 覆盖父类的方法，提供真正的加密实现
         * 这里对密码进行加密，比如使用MD5、3DES等，省略了
         */
        System.out.println("使用MD5进行密码的加密");
        return pwd;
    }
}
