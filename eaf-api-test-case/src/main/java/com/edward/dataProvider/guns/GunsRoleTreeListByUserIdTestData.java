package com.edward.dataProvider.guns;

import com.edward.common.EnumCode;
import com.edward.requestbean.guns.bean.GunsRoleTreeListByUserIdRequestBean;
import org.springframework.stereotype.Component;

@Component
public class GunsRoleTreeListByUserIdTestData {

    public Object[][] genGunsRoleTreeListByUserIdTestData() {
        Integer userId = 1;

        GunsRoleTreeListByUserIdRequestBean requestBean = new GunsRoleTreeListByUserIdRequestBean();
        requestBean.setUserId(userId);


        return new Object[][]{
                {"根据userId获取用户权限", requestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
