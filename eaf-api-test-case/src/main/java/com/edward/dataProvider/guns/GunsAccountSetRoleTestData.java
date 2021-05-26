package com.edward.dataProvider.guns;

import com.edward.common.EnumCode;
import com.edward.requestbean.guns.bean.GunsAccountSetRoleRequestBean;

/**
 * @author wangcheng
 * @date 2020/5/11 18:18
 */
public class GunsAccountSetRoleTestData {
    public Object[][] genGunsAccountSetRoleTestData() {
        Integer userId = 7;
        String roleIds = "1";

        GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean = new GunsAccountSetRoleRequestBean();
        gunsAccountSetRoleRequestBean.setUserId(userId);
        gunsAccountSetRoleRequestBean.setRoleIds(roleIds);

        return new Object[][]{
                {"根据userId为用户添加角色", gunsAccountSetRoleRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
