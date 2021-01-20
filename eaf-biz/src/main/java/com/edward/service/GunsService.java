package com.edward.service;

import com.edward.appcaller.GunsAppCaller;
import com.edward.common.AES256Utils;
import com.edward.common.EnumCode;
import com.edward.requestbean.guns.bean.*;
import com.edward.responsebean.basic.BaseRes;
import com.edward.responsebean.basic.PageRes;
import com.edward.responsebean.guns.UserDto;
import com.edward.responsebean.guns.ZTreeNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcheng
 * @date 2020/5/12 15:14
 */
public class GunsService extends BaseService{

    public void loginStudioByAccount(String name,String decPwd){
        //1、登陆admin账户，获取token
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
        Assert.assertEquals(loginResponse.getCode(), EnumCode.BASE_SUCCESS.getCode());
    }

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
        String addAccount = "wangcheng";
        String addAccountPassword = getEncPwd("Edward2019@");
        String email = "wangcheng@qq.com";
        String accountName = "wangcheng";
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
        BaseRes<ArrayList<ZTreeNode>> baseRes = gson.fromJson(gunsRoleTreeListByUserIdResponseString,new TypeToken<BaseRes<ArrayList<ZTreeNode>>>(){}.getType());
        ZTreeNode adminRole = null;
        for(int i=0;i<baseRes.getData().size();i++ ){
            //边离roles列表，获取admin角色
            if(baseRes.getData().get(i).getId() == 1){
                adminRole = baseRes.getData().get(i);
                break;

            }
        }

        //4、根据accountName查询account信息-模糊查询
        String queryAcountName = addAccount;
        Integer count = 1;
        Integer pageSise = 10;

        GunsAccountListRequestBean gunsAccountListRequestBean = new GunsAccountListRequestBean();
        gunsAccountListRequestBean.setName(queryAcountName);
        gunsAccountListRequestBean.setCurrent(count);
        gunsAccountListRequestBean.setSize(pageSise);
        String responseString = new GunsAppCaller().getGunsAccountList(gunsAccountListRequestBean);
        PageRes<ArrayList<UserDto>> pageRes = gson.fromJson(responseString, new TypeToken<PageRes<ArrayList<UserDto>>>(){}.getType());
        UserDto userDto = null;
        for(int i=0;i<pageRes.getData().size();i++ ){
            //遍历account列表，获取对应的account
            if(pageRes.getData().get(i).getName().equals(addAccount)){
                userDto = pageRes.getData().get(i);
                break;

            }
        }

        //5、为新添加的用户设置admin角色
        Integer userDtoId = userDto.getId();
        GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean = new GunsAccountSetRoleRequestBean();
        gunsAccountSetRoleRequestBean.setUserId(userDtoId);
        gunsAccountSetRoleRequestBean.setRoleIds(adminRole.getId().toString());
        String accountSetRoleResponseString = new GunsAppCaller().getGunsAccountSetRole(gunsAccountSetRoleRequestBean);
        BaseRes accountSetRoleBaseRes = gson.fromJson(accountSetRoleResponseString, BaseRes.class);

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
