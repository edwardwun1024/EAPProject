package com.edward.app.cognitivexswitcher;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.CognitiveSwitcherAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.cognitivexswitcher.CognitiveXswitcherCognitiveDeviceInfraFrameTestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2021/1/26 15:37
 */
public class CognitiveXswitcherCognitiveDeviceInfraFrameTest extends BaseApiTest {
    @Autowired
    public CognitiveSwitcherAppCaller cognitiveSwitcherAppCaller;

    @DataProvider(name = "dataPrdCognitiveXswitcherCognitiveDeviceInfraFrameTest")
    public Object[][] getDataProviderGetCognitiveXswitcherCognitiveDeviceInfraFrameDataProvider() {
        CognitiveXswitcherCognitiveDeviceInfraFrameTestData gunsRoleTreeListByUserIdTestData = new CognitiveXswitcherCognitiveDeviceInfraFrameTestData();
        return gunsRoleTreeListByUserIdTestData.genCognitiveXswitcherCognitiveDeviceInfraFrameTestData();
    }


    @Test(dataProvider = "dataPrdCognitiveXswitcherCognitiveDeviceInfraFrameTest")
    public void testGetCognitiveXswitcherCognitiveDeviceInfraFrame(String caseName, String rtsp, EnumCode enumCode) {

        logger.info("--------------" + caseName + " start--------------");
//        String responseString = new CognitiveSwitcherAppCaller().getCognitiveDeviceInfraFetchFrame(rtsp);
//        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
//        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
//        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------" + caseName + " end--------------");
    }
}
