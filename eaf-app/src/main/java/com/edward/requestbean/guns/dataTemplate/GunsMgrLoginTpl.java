package com.edward.requestbean.guns.dataTemplate;

import com.edward.requestbean.guns.bean.GunsMgrLoginRequestBean;

/**
 * @author wangcheng
 * @date 2019/12/16 11:06
 */

public class GunsMgrLoginTpl {
    public static class TestValues {

        public static final String userName = null;
        public static final String password = null;
        public static final String accountType = null;
    }

    public GunsMgrLoginRequestBean buildData() {
        GunsMgrLoginRequestBean data = new GunsMgrLoginRequestBean();
        data.setUsername(TestValues.userName);
        data.setPassword(TestValues.password);
        data.setAccountType(TestValues.accountType);
        return data;
    }
}
