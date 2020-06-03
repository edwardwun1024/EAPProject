package com.edward.app.guns;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.GunsAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.guns.GunsAccountListTestData;
import com.edward.requestbean.guns.bean.GunsAccountListRequestBean;
import com.edward.responsebean.basic.BaseRes;
import com.edward.responsebean.basic.PageRes;
import com.edward.responsebean.guns.UserDto;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * 根据条件查询账号
 * @author wangcheng
 * @date 2020/6/3 15:12
 */
public class GunsAccountListTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGetGunsAccountList")
    public Object[][] getDataProviderGetGunsAccountListDataProvider( ){
        //通过context.class 获取PersonGroupListTestData.genPersonGroupListTestData
        GunsAccountListTestData gunsAccountListTestData = new GunsAccountListTestData();
        return gunsAccountListTestData.genAccountListTestData();
    }


    @Test(dataProvider = "dataPrdGetGunsAccountList")
    public void testGetGunsAccountListTest(String caseName, GunsAccountListRequestBean gunsAccountListRequestBean, EnumCode enumCode){
        logger.info("--------------"+caseName+" start--------------");
        String responseString = new GunsAppCaller().getGunsAccountList(gunsAccountListRequestBean);
        PageRes<ArrayList<UserDto>> pageRes = gson.fromJson(responseString, new TypeToken<PageRes<ArrayList<UserDto>>>(){}.getType());
        Assert.assertEquals(pageRes.getCode(),enumCode.getCode());
        Assert.assertEquals(pageRes.getMsg(),enumCode.getMsg());
        Assert.assertNotEquals(pageRes.getData().size(),0);
        logger.info("--------------"+caseName+" end--------------");
    }
}
