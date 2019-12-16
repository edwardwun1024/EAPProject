package com.edward.dataProvider.guns;

import com.edward.common.EnumCode;
import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;

/**
 * @author wangcheng
 * @date 2019/12/16 19:13
 */
public class GunsAccountAddTestData {

    public Object[][] genGunsAccountAddTestData(){
        String account = "testwc02";
        String password = "iEp5Op2lnXR3r6pNwWy5cA==";
        String email = "testwc@qq.com";
        String name = "testwc";
        String rePassword = "iEp5Op2lnXR3r6pNwWy5cA==";
        Integer deptid = 0;
        String phone = "16602103425";
        Integer createUser = 72;
        String accountType = "0";


        GunsAccountAddRequestBean gunsAccountAddRequestBean = new GunsAccountAddRequestBean();
        gunsAccountAddRequestBean.setAccount(account);
        gunsAccountAddRequestBean.setPassword(password);
        gunsAccountAddRequestBean.setEmail(email);
        gunsAccountAddRequestBean.setName(name);
        gunsAccountAddRequestBean.setRePassword(rePassword);
        gunsAccountAddRequestBean.setDeptid(deptid);
        gunsAccountAddRequestBean.setPhone(phone);
        gunsAccountAddRequestBean.setCreateUser(createUser);
        gunsAccountAddRequestBean.setAccountType(accountType);


        return new Object[][]{
                {"用户登陆studio",gunsAccountAddRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
