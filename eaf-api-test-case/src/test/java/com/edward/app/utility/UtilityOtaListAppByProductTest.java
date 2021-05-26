package com.edward.app.utility;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.UtilityAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.utility.UtilityOtaListAppByProductTestData;
import com.edward.requestbean.utility.bean.UtilityOtaListAppByProductRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2020/6/9 10:41
 */
public class UtilityOtaListAppByProductTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGetUtilityOtaListAppByProductTest")
    public Object[][] getDataProviderGetUtilityOtaListAppByProductDataProvider() {
        UtilityOtaListAppByProductTestData utilityOtaListAppByProductTestData = new UtilityOtaListAppByProductTestData();
        return utilityOtaListAppByProductTestData.genUtilityOtaListAppByProductTestData();
    }


    @Test(dataProvider = "dataPrdGetUtilityOtaListAppByProductTest")
    public void testGetUtilityOtaListAppByProductTest(String caseName, UtilityOtaListAppByProductRequestBean utilityOtaListAppByProductRequestBean, EnumCode enumCode) {

        logger.info("--------------" + caseName + " start--------------");
        String responseString = new UtilityAppCaller().getUtilityOtaListAppByProduct(utilityOtaListAppByProductRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(), enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(), enumCode.getMsg());
        logger.info("--------------" + caseName + " end--------------");
    }
}
