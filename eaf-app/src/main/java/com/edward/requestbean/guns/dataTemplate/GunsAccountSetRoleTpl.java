package com.edward.requestbean.guns.dataTemplate;

import com.edward.requestbean.guns.bean.GunsAccountSetRoleRequestBean;

/**
 * @author wangcheng
 * @date 2020/5/12 16:10
 */
public class GunsAccountSetRoleTpl {
    private static class TestValue{
        private static final Integer userId = null;
        private static final String roleIds = null;
    }

    public GunsAccountSetRoleRequestBean buildData(){
        GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean = new GunsAccountSetRoleRequestBean();
        gunsAccountSetRoleRequestBean.setUserId(TestValue.userId);
        gunsAccountSetRoleRequestBean.setRoleIds(TestValue.roleIds);
        return gunsAccountSetRoleRequestBean;
    }
}
