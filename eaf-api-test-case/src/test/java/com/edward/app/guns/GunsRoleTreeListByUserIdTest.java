package com.edward.app.guns;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.GunsAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.guns.GunsRoleTreeListByUserIdTestData;
import com.edward.requestbean.guns.bean.GunsRoleTreeListByUserIdRequestBean;
import com.edward.responsebean.basic.BaseRes;
import com.edward.responsebean.guns.ZTreeNode;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;


/**
 * url:role/roleTreeListByUserId
 * 功能：根据userId获取user权限
 */
public class GunsRoleTreeListByUserIdTest extends BaseApiTest {
    @Autowired
    public GunsAppCaller gunsAppCaller;

    @DataProvider(name = "dataPrdGunsRoleTreeListByUserIdTest")
    public Object[][] getDataProviderGetGunsRoleTreeListByUserIdDataProvider( ){
        GunsRoleTreeListByUserIdTestData gunsRoleTreeListByUserIdTestData = new GunsRoleTreeListByUserIdTestData();
        return gunsRoleTreeListByUserIdTestData.genGunsRoleTreeListByUserIdTestData();
    }


    @Test(dataProvider = "dataPrdGunsRoleTreeListByUserIdTest")
    public void testGetGunsRoleTreeListByUserId(String caseName, GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new GunsAppCaller().getGunsRoleTreeListByUserId(gunsRoleTreeListByUserIdRequestBean);
        BaseRes<ArrayList<ZTreeNode>> response = gson.fromJson(responseString,new TypeToken<BaseRes<ArrayList<ZTreeNode>>>(){}.getType());
        Assert.assertEquals(response.getCode(),enumCode.getCode());
        Assert.assertNotNull(response.getData().size());
        Assert.assertEquals(response.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
