package com.edward.app.guns;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.GunsAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.guns.GunsMgrLoginTestData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.edward.requestbean.guns.bean.GunsMgrLoginRequestBean;
import com.edward.responsebean.basic.BaseRes;


/**
 * 功能：用户登陆
 * @author wangcheng
 * @date 2019/12/16 19:12
 */
public class GunsMgrLoginTest extends BaseApiTest {

    @DataProvider(name = "dataPrdGetGunsMgrLoginTest")
    public Object[][] getDataProviderGetGunsMgrLoginDataProvider( ){
        //通过context.class 获取PersonGroupListTestData.genPersonGroupListTestData
//        GunsMgrLoginTestData gunsMgrLoginTestData = SpringContextHolder.getBean(GunsMgrLoginTestData.class);
        GunsMgrLoginTestData gunsMgrLoginTestData = new GunsMgrLoginTestData();
        return gunsMgrLoginTestData.genGunsMgrLoginTestData();
    }


    @Test(dataProvider = "dataPrdGetGunsMgrLoginTest")
    public void testGetGunsMgrLoginTest(String caseName, GunsMgrLoginRequestBean gunsMgrLoginRequestBean, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new GunsAppCaller().getGunsMgrLogin(gunsMgrLoginRequestBean);
//        String responseString = gunsAppCaller.getGunsMgrLogin(gunsMgrLoginRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
