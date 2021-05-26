package com.edward.app.utility;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.UtilityAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.utility.UtilityOtaIsExistsTestData;
import com.edward.requestbean.utility.bean.UtilityOtaIsExistsRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2020/6/9 10:55
 */
public class UtilityOtaIsExistsTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGetUtilityOtaIsExistsTest")
    public Object[][] getDataProviderGetUtilityOtaIsExistsDataProvider() {
        UtilityOtaIsExistsTestData utilityOtaIsExistsTestData = new UtilityOtaIsExistsTestData();
        return utilityOtaIsExistsTestData.genUtilityOtaIsExistsTestData();
    }


    @Test(dataProvider = "dataPrdGetUtilityOtaIsExistsTest")
    public void testGeUtilityOtaIsExistsTest(String caseName, UtilityOtaIsExistsRequestBean utilityOtaIsExistsRequestBean, EnumCode enumCode) {

        logger.info("--------------" + caseName + " start--------------");
        String responseString = new UtilityAppCaller().getUtilityOtaIsExists(utilityOtaIsExistsRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(), enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(), enumCode.getMsg());
        logger.info("--------------" + caseName + " end--------------");
    }
}
