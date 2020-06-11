package com.edward.dataProvider.utility;

import com.edward.common.EnumCode;
import com.edward.requestbean.utility.bean.UtilityOtaIsExistsRequestBean;

/**
 * @author wangcheng
 * @date 2020/6/9 10:55
 */
public class UtilityOtaIsExistsTestData {
    public Object[][] genUtilityOtaIsExistsTestData() {
        UtilityOtaIsExistsRequestBean utilityOtaIsExistsRequestBean = new UtilityOtaIsExistsRequestBean();

        return new Object[][]{
                {"检查包信息是否存在",utilityOtaIsExistsRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
