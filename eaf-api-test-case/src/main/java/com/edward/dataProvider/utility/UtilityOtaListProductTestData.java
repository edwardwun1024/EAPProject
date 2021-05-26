package com.edward.dataProvider.utility;

import com.edward.common.EnumCode;
import com.edward.requestbean.utility.bean.UtilityOtaListProductRequestBean;

/**
 * @author wangcheng
 * @date 2020/6/9 10:34
 */
public class UtilityOtaListProductTestData {
    public Object[][] genUtilityOtaListProductTestData() {
        UtilityOtaListProductRequestBean utilityOtaListProductRequestBean = new UtilityOtaListProductRequestBean();

        return new Object[][]{
                {"获取产品", utilityOtaListProductRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
