package com.edward.dataProvider.utility;

import com.edward.common.EnumCode;
import com.edward.requestbean.utility.bean.UtilityOtaListAppByProductRequestBean;

/**
 * @author wangcheng
 * @date 2020/6/9 10:41
 */
public class UtilityOtaListAppByProductTestData {
    public Object[][] genUtilityOtaListAppByProductTestData() {
        //产品类型：pass
        String product1 = "13";
        UtilityOtaListAppByProductRequestBean utilityOtaListAppByProductRequestBean1 = new UtilityOtaListAppByProductRequestBean();
        utilityOtaListAppByProductRequestBean1.setProduct(product1);

        //产品类型：nebula
        String product2 = "11";
        UtilityOtaListAppByProductRequestBean utilityOtaListAppByProductRequestBean2 = new UtilityOtaListAppByProductRequestBean();
        utilityOtaListAppByProductRequestBean2.setProduct(product2);

        return new Object[][]{
                {"获取产品应用-sensepass",utilityOtaListAppByProductRequestBean1, EnumCode.BASE_SUCCESS},
                {"获取产品应用-nebula",utilityOtaListAppByProductRequestBean2, EnumCode.BASE_SUCCESS}

        };
    }
}
