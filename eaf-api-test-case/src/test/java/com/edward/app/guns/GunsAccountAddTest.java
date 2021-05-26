package com.edward.app.guns;

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
 * 功能：添加用户
 *
 * @author wangcheng
 * @date 2019/12/16 19:12
 */
public class GunsAccountAddTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGetGunsAccountAdd")
    public Object[][] getDataProviderGetGunsMgrLoginDataProvider() {
        GunsAccountAddTestData gunsAccountAddTestData = new GunsAccountAddTestData();
        return gunsAccountAddTestData.genGunsAccountAddTestData();
    }


    @Test(dataProvider = "dataPrdGetGunsAccountAdd")
    public void testGetGunsMgrLoginTest(String caseName, GunsAccountAddRequestBean gunsAccountAddRequestBean, EnumCode enumCode) {
        logger.info("--------------" + caseName + " start--------------");
        String responseString = new GunsAppCaller().getGunsAccountAdd(gunsAccountAddRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(), enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(), enumCode.getMsg());
        logger.info("--------------" + caseName + " end--------------");
    }
}
