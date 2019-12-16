package com.edward.guns;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.GunsAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.guns.GunsMgrLoginTestData;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.edward.requestbean.guns.bean.GunsMgrLoginRequestBean;
import com.edward.responsebean.basic.BaseRes;

@Slf4j
public class GunsMgrLoginTest extends BaseApiTest {

    @DataProvider(name = "dataPrdGetGunsMgrLoginTest")
    public Object[][] getDataProviderGetGunsMgrLoginDataProvider( ){
        //通过context.class 获取PersonGroupListTestData.genPersonGroupListTestData
        GunsMgrLoginTestData gunsMgrLoginTestData = new GunsMgrLoginTestData();
        return gunsMgrLoginTestData.genGunsMgrLoginTestData();
    }


    @Test(dataProvider = "dataPrdGetGunsMgrLoginTest")
    public void testGetGunsMgrLoginTest(String caseName, GunsMgrLoginRequestBean gunsMgrLoginRequestBean, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new GunsAppCaller().getGunsMgrLogin(gunsMgrLoginRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
