package com.edward.app.device;

import com.edward.Base.BaseApiTest;
import com.edward.app.DeviceApp;
import com.edward.appcaller.DeviceAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.device.DeviceCreateTestData;
import com.edward.requestbean.device.bean.DeviceCreateRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2021/1/20 11:34
 */
public class DeviceCreateTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGetDeviceCreateTest")
    public Object[][] getDataProviderGetDeviceCreateDataProvider( ){
        DeviceCreateTestData deviceCreateTestData = new DeviceCreateTestData();
        return deviceCreateTestData.genDeviceCreateTestData();
    }


    @Test(dataProvider = "dataPrdGetDeviceCreateTest")
    public void testGetDeviceCreateTest(String caseName, DeviceCreateRequestBean deviceCreateRequestBean, EnumCode enumCode){

        logger.info("--------------"+caseName+" start--------------");
        String responseString = new DeviceAppCaller().getDeviceCreate(deviceCreateRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(),enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
