package com.edward.dataProvider.guns;

import com.edward.common.EnumCode;
import com.edward.requestbean.guns.bean.GunsAccountListRequestBean;

/**
 * @author wangcheng
 * @date 2020/6/3 15:13
 */
public class GunsAccountListTestData {
    public Object[][] genAccountListTestData() {
        String accountName = "wangcheng";
        Integer count = 1;
        Integer pageSise = 10;

        GunsAccountListRequestBean gunsAccountListRequestBean = new GunsAccountListRequestBean();
        gunsAccountListRequestBean.setName(accountName);
        gunsAccountListRequestBean.setCurrent(count);
        gunsAccountListRequestBean.setSize(pageSise);




        return new Object[][]{
                {"添加账号",gunsAccountListRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
