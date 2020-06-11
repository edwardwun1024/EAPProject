package com.edward.app.utility;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.UtilityAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.utility.UtilityOtaUpdatePackageTestData;
import com.edward.requestbean.utility.bean.UtilityOtaUpdatePackageRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2020/6/9 11:24
 */
public class UtilityOtaUpdatePackageTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGetUtilityOtaUpdatePackageTest")
    public Object[][] getDataProviderGetUtilityOtaUpdatePackageDataProvider( ){
        UtilityOtaUpdatePackageTestData utilityOtaUpdatePackageTestData = new UtilityOtaUpdatePackageTestData();
        return utilityOtaUpdatePackageTestData.genUtilityOtaUpdatePackageTestData();
    }


    @Test(dataProvider = "dataPrdGetUtilityOtaUpdatePackageTest")
    public void testGetUtilityOtaUpdatePackageTest(String caseName, UtilityOtaUpdatePackageRequestBean utilityOtaUpdatePackageRequestBean, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new UtilityAppCaller().getUtilityOtaUpdatePackage(utilityOtaUpdatePackageRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
