package com.edward.requestbean.guns.dataTemplate;

import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;
import com.edward.requestbean.guns.bean.GunsRoleTreeListByUserIdRequestBean;

/**
 * @author wangcheng
 * @date 2020/5/12 16:06
 */
public class GunsRoleTreeListByUserIdTpl {
    private static class TestValue{
        private static final Integer userId = null;
    }

    public GunsRoleTreeListByUserIdRequestBean buildData(){
        GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean = new GunsRoleTreeListByUserIdRequestBean();
        gunsRoleTreeListByUserIdRequestBean.setUserId(TestValue.userId);
        return gunsRoleTreeListByUserIdRequestBean;
    }
}
