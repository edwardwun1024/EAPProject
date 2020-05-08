package com.edward.dataProvider.guns;

import com.edward.common.AES256Utils;
import com.edward.common.EnumCode;
import com.edward.requestbean.guns.bean.GunsMgrLoginRequestBean;
import org.springframework.stereotype.Component;

@Component
public class GunsMgrLoginTestData {

    public Object[][] genGunsMgrLoginTestData(){
        String name = "wangcheng";
        String decPwd = "Edward2019@";
        String accountType = "0";
        String encPwd = null;
        String dectoPwd = null;

        try {
            encPwd = AES256Utils.encrypt(decPwd.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        GunsMgrLoginRequestBean gunsMgrLoginRequestBean = new GunsMgrLoginRequestBean();
        gunsMgrLoginRequestBean.setUsername(name);
        gunsMgrLoginRequestBean.setPassword(encPwd);
        gunsMgrLoginRequestBean.setAccountType(accountType);

        return new Object[][]{
                {"用户登陆studio",gunsMgrLoginRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
