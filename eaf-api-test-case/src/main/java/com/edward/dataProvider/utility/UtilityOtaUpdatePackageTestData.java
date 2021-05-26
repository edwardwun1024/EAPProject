package com.edward.dataProvider.utility;

import com.edward.common.EnumCode;
import com.edward.requestbean.utility.bean.UtilityOtaUpdatePackageRequestBean;

/**
 * @author wangcheng
 * @date 2020/6/9 11:25
 */
public class UtilityOtaUpdatePackageTestData {
    public Object[][] genUtilityOtaUpdatePackageTestData() {
        UtilityOtaUpdatePackageRequestBean utilityOtaUpdatePackageRequestBean = new UtilityOtaUpdatePackageRequestBean();

        return new Object[][]{
                {"更新包版本信息", utilityOtaUpdatePackageRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
