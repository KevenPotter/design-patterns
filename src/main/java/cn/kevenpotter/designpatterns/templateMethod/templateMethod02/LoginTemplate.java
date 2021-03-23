package cn.kevenpotter.designpatterns.templateMethod.templateMethod02;

import cn.kevenpotter.designpatterns.templateMethod.templateMethod02.model.LoginModel;

public abstract class LoginTemplate {

    /**
     * 判断登陆数据是否正确，也就是是否能登录成功
     */
    public final boolean login(LoginModel lm) {
        // 1.根据登录人员的编号去获取相应的数据
        LoginModel dbLm = this.findLoginUser(lm.getLoginId());
        if (dbLm != null) {
            // 2.对密码进行加密
            String encryptPwd = this.encryptPwd(lm.getPwd());
            // 3.把加密后的密码设置回到登陆数据模型中
            lm.setPwd(encryptPwd);
            return this.match(lm, dbLm);
        }
        return false;
    }

    /**
     * 根据登录编号来查找和获取存储中相应的数据
     */
    public abstract LoginModel findLoginUser(String loginId);

    /**
     * 对密码数据进行加密
     */
    public String encryptPwd(String pwd) {
        return pwd;
    }

    /**
     * 判断用户填写的登录数据和存储中对应的数据是否匹配的上
     */
    public boolean match(LoginModel lm, LoginModel dbLm) {
        return lm.getLoginId().equals(dbLm.getLoginId()) && lm.getPwd().equals(dbLm.getPwd());
    }
}
