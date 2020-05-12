package com.edward.app.guns;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.GunsAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.guns.GunsAccountSetRoleTestData;
import com.edward.requestbean.guns.bean.GunsAccountSetRoleRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 功能：根据userId为用户添加角色
 * url：/GUNS/account/setRole
 * @author wangcheng
 * @date 2020/5/11 18:18
 */
public class GunsAccountSetRoleTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGunsAccountSetRoleTest")
    public Object[][] getDataProviderGetGunsRoleTreeListByUserIdDataProvider( ){
        GunsAccountSetRoleTestData gunsRoleTreeListByUserIdTestData = new GunsAccountSetRoleTestData();
        return gunsRoleTreeListByUserIdTestData.genGunsAccountSetRoleTestData();
    }


    @Test(dataProvider = "dataPrdGunsAccountSetRoleTest")
    public void testGetGunsRoleTreeListByUserId(String caseName, GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean,String authorization, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new GunsAppCaller().getGunsAccountSetRole(gunsAccountSetRoleRequestBean, authorization);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
