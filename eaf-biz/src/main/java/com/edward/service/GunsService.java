package com.edward.service;

import com.edward.appcaller.GunsAppCaller;
import com.edward.common.AES256Utils;
import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;
import com.edward.requestbean.guns.bean.GunsMgrLoginRequestBean;
import com.edward.requestbean.guns.bean.GunsRoleTreeListByUserIdRequestBean;
import com.edward.responsebean.basic.BaseRes;
import com.edward.responsebean.guns.ZTreeNode;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * @author wangcheng
 * @date 2020/5/12 15:14
 */
public class GunsService {
    public static final Logger logger = Logger.getLogger("HttpClient(异步)工具类");
    public static final Gson gson = new Gson();
    public GunsAppCaller gunsAppCaller = new GunsAppCaller();

    /**
     * 在top部门下创建一个角色为admin的用户
     * 1、登陆admin账户
     * 2、创建account
     * 3、设置角色
     */
    public String genAccountWithAdminRole(){

        //1、登陆admin账户，获取token
        String name = "admin";
        String decPwd = "st#000000";
        String accountType = "0";
        String encPwd = null;
        try {
            encPwd = AES256Utils.encrypt(decPwd.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        GunsMgrLoginRequestBean gunsMgrLoginRequestBean = new GunsMgrLoginRequestBean();
        gunsMgrLoginRequestBean.setUsername(name);
        gunsMgrLoginRequestBean.setPassword(encPwd);
        gunsMgrLoginRequestBean.setAccountType(accountType);
        String gunsMrgLoginResponse = gunsAppCaller.getGunsMgrLogin(gunsMgrLoginRequestBean);
        BaseRes loginResponse = gson.fromJson(gunsMrgLoginResponse, BaseRes.class);

        //2、创建account
        String addAccount = "wangcheng1";
        String addAccountPassword = getEncPwd("Edward2019@");
        String email = "wangcheng@qq.com";
        String accountName = "wangcheng1";
        String addAccountRePassword = addAccountPassword;
        Integer deptid = 0;
        String phone = "16602103425";
        Integer createUser = 1;
        String addAccountType = "0";

        GunsAccountAddRequestBean gunsAccountAddRequestBean = new GunsAccountAddRequestBean();
        gunsAccountAddRequestBean.setAccount(addAccount);
        gunsAccountAddRequestBean.setPassword(addAccountPassword);
        gunsAccountAddRequestBean.setEmail(email);
        gunsAccountAddRequestBean.setName(accountName);
        gunsAccountAddRequestBean.setRePassword(addAccountRePassword);
        gunsAccountAddRequestBean.setDeptid(deptid);
        gunsAccountAddRequestBean.setPhone(phone);
        gunsAccountAddRequestBean.setCreateUser(createUser);
        gunsAccountAddRequestBean.setAccountType(addAccountType);
        String  gunsAccountAddResponse=gunsAppCaller.getGunsAccountAdd(gunsAccountAddRequestBean);

        //3、获取用户所有角色权限
        Integer userId = 1;
        GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean = new GunsRoleTreeListByUserIdRequestBean();
        gunsRoleTreeListByUserIdRequestBean.setUserId(userId);
        String gunsRoleTreeListByUserIdResponseString = new GunsAppCaller().getGunsRoleTreeListByUserId(gunsRoleTreeListByUserIdRequestBean);
        BaseRes<ZTreeNode> gunsRoleTreeListByUserIdBaseResponse = gson.fromJson(gunsRoleTreeListByUserIdResponseString, BaseRes.class);





        return "";
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
