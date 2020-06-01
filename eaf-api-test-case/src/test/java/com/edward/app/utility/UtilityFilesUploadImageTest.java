package com.edward.app.utility;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.UtilityAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.utility.UtilityFilesUploadImageTestData;
import com.edward.requestbean.utility.bean.UtilityFilesUploadImageRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2020/5/27 15:33
 */
public class UtilityFilesUploadImageTest extends BaseApiTest {

    @DataProvider(name = "dataPrdGetUtilityFilesUploadImageTest")
    public Object[][] getDataProviderGetGunsMgrLoginDataProvider( ){
        UtilityFilesUploadImageTestData utilityFilesUploadImageTestData = new UtilityFilesUploadImageTestData();
        return utilityFilesUploadImageTestData.genUtilityFilesUploadImageTestData();
    }


    @Test(dataProvider = "dataPrdGetUtilityFilesUploadImageTest")
    public void testGetGunsMgrLoginTest(String caseName, UtilityFilesUploadImageRequestBean utilityFilesUploadImageRequestBean, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new UtilityAppCaller().getUtilityFilesUploadImage(utilityFilesUploadImageRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
