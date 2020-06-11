package com.edward.app.utility;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.UtilityAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.utility.UtilityOtaListProductTestData;
import com.edward.requestbean.utility.bean.UtilityOtaListProductRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2020/6/9 10:34
 */
public class UtilityOtaListProductTest extends BaseApiTest {

    @DataProvider(name = "dataPrdGetUtilityOtaListProductTest")
    public Object[][] getDataProviderGetGunsMgrLoginDataProvider( ){
        UtilityOtaListProductTestData utilityOtaListProductTestData = new UtilityOtaListProductTestData();
        return utilityOtaListProductTestData.genUtilityOtaListProductTestData();
    }


    @Test(dataProvider = "dataPrdGetUtilityOtaListProductTest")
    public void testGetGunsMgrLoginTest(String caseName, UtilityOtaListProductRequestBean utilityOtaListProductRequestBean, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new UtilityAppCaller().getUtilityOtaListProduct(utilityOtaListProductRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
