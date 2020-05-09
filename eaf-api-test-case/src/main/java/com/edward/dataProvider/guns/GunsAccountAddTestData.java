package com.edward.dataProvider.guns;

import com.edward.common.AES256Utils;
import com.edward.common.EnumCode;
import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;

/**
 * @author wangcheng
 * @date 2019/12/16 19:13
 */
public class GunsAccountAddTestData {

    public Object[][] genGunsAccountAddTestData(){



        String account = "wangcheng";
        String password = getEncPwd("Edward2019@");
        String email = "wangcheng@qq.com";
        String name = "wangcheng";
        String rePassword = password;
        Integer deptid = 0;
        String phone = "16602103425";
        Integer createUser = 1;
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
                {"添加账号",gunsAccountAddRequestBean, EnumCode.BASE_SUCCESS}
        };
    }

    public String getEncPwd(String decPwd){
        String encPwd = null;
        try {
            encPwd= AES256Utils.encrypt(decPwd.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encPwd;
    }



}
