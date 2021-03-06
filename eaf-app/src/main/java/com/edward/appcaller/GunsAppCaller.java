package com.edward.appcaller;

import com.edward.http.HttpApi;
import com.edward.requestbean.guns.bean.*;

import static com.edward.app.GunsApp.*;

public class GunsAppCaller extends AbstractServiceCaller {

    public String getGunsMgrLogin(GunsMgrLoginRequestBean gunsMgrLoginRequestBean){
        return this.getPostgetGunsMgrLogin(POST_GUNS_MGR_LOGIN,gunsMgrLoginRequestBean);
    }
    private String getPostgetGunsMgrLogin(HttpApi POST_GUNS_MGR_LOGIN, GunsMgrLoginRequestBean gunsMgrLoginRequestBean){
        return doPost(POST_GUNS_MGR_LOGIN,gunsMgrLoginRequestBean);
    }

    public String getGunsAccountAdd(GunsAccountAddRequestBean gunsAccountAddRequestBean){
        return this.getGunsAccountAdd(POST_GUNS_ACCOUNT_ADD,gunsAccountAddRequestBean);
    }
    private String getGunsAccountAdd(HttpApi POST_GUNS_ACCOUNT_ADD, GunsAccountAddRequestBean gunsAccountAddRequestBean){
        return doPost(POST_GUNS_ACCOUNT_ADD,gunsAccountAddRequestBean);
    }

    public String getGunsRoleTreeListByUserId(GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean){
        return this.getGunsRoleTreeListByUserId(POST_GUNS_ROLE_TREE_LIST_BY_USERID,gunsRoleTreeListByUserIdRequestBean);
    }
    private String getGunsRoleTreeListByUserId(HttpApi POST_GUNS_ROLE_TREE_LIST_BY_USERID, GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean){
        return doPost(POST_GUNS_ROLE_TREE_LIST_BY_USERID, gunsRoleTreeListByUserIdRequestBean);
    }

    public String getGunsAccountSetRole(GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean){
        return this.getGunsAccountSetRole(POST_GUNS_ACCOUNT_SETROLE,gunsAccountSetRoleRequestBean);
    }
    private String getGunsAccountSetRole(HttpApi POST_GUNS_ROLE_TREE_LIST_BY_USERID,GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean){
        return doPost(POST_GUNS_ACCOUNT_SETROLE,gunsAccountSetRoleRequestBean);
    }

    public String getGunsAccountList(GunsAccountListRequestBean gunsAccountListRequestBean){
        return getGunsAccountList(POST_GUNS_ACCOUNT_LIST,gunsAccountListRequestBean);
    }
    private String getGunsAccountList(HttpApi POST_GUNS_ACCOUNT_LIST, GunsAccountListRequestBean gunsAccountListRequestBean){
        return doPost(POST_GUNS_ACCOUNT_LIST,gunsAccountListRequestBean);
    }

}
