package com.edward.requestbean.guns.dataTemplate;

import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;

/**
 * @author wangcheng
 * @date 2020/5/12 15:56
 */
public class GunsAccountAddTpl {
    public static class TestValue{
        private static final String account = null;
        private static final String name = null;
        private static final String password = null;
        private static final String rePassword = null;
        private static final String email = null;
        private static final String phone = null;
        private static final Integer deptid = null;
        private static final String accountType = null;
        private static final Integer createUser = null;
    }

    public GunsAccountAddRequestBean buildData(){
        GunsAccountAddRequestBean gunsAccountAddRequestBean = new GunsAccountAddRequestBean();
        gunsAccountAddRequestBean.setAccount(TestValue.account);
        gunsAccountAddRequestBean.setName(TestValue.name);
        gunsAccountAddRequestBean.setPassword(TestValue.password);
        gunsAccountAddRequestBean.setRePassword(TestValue.rePassword);
        gunsAccountAddRequestBean.setEmail(TestValue.email);
        gunsAccountAddRequestBean.setPhone(TestValue.phone);
        gunsAccountAddRequestBean.setDeptid(TestValue.deptid);
        gunsAccountAddRequestBean.setAccountType(TestValue.accountType);
        gunsAccountAddRequestBean.setCreateUser(TestValue.createUser);
        return gunsAccountAddRequestBean;
    }


}
