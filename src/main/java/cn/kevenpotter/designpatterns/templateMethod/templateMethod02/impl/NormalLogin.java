package cn.kevenpotter.designpatterns.templateMethod.templateMethod02.impl;

import cn.kevenpotter.designpatterns.templateMethod.templateMethod02.LoginTemplate;
import cn.kevenpotter.designpatterns.templateMethod.templateMethod02.model.LoginModel;

public class NormalLogin extends LoginTemplate {

    @Override
    public LoginModel findLoginUser(String loginId) {
        LoginModel lm = new LoginModel();
        lm.setLoginId(loginId);
        lm.setPwd("testpwd");
        return lm;
    }
}
