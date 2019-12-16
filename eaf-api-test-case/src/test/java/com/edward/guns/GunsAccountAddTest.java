package com.edward.guns;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.GunsAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.guns.GunsAccountAddTestData;
import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2019/12/16 19:12
 */
public class GunsAccountAddTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGetGunsMgrLoginTest")
    public Object[][] getDataProviderGetGunsMgrLoginDataProvider( ){
        //通过context.class 获取PersonGroupListTestData.genPersonGroupListTestData
        GunsAccountAddTestData gunsAccountAddTestData = new GunsAccountAddTestData();
        return gunsAccountAddTestData.genGunsAccountAddTestData();
    }


    @Test(dataProvider = "dataPrdGetGunsMgrLoginTest")
    public void testGetGunsMgrLoginTest(String caseName, GunsAccountAddRequestBean gunsAccountAddRequestBean, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new GunsAppCaller().getGunsAccountAdd(gunsAccountAddRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
