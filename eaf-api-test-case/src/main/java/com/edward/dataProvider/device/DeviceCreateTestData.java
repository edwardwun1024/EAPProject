package com.edward.dataProvider.device;

import com.edward.common.EnumCode;
import com.edward.requestbean.device.bean.DeviceCreateRequestBean;

/**
 * @author wangcheng
 * @date 2021/1/20 11:22
 */
public class DeviceCreateTestData {
    public Object[][] genDeviceCreateTestData(){

        String deviceCnName = "wc-region-98";
        String deviceSerial = "id-wc-region-98";
        String deviceTag = "qa";
        String deviceType = "21";
        String productType = "16";
        String deviceUri = "rtsp://admin:Sense123789456@10.151.23.98:554";
        String deviceIp = "10.151.23.98";
        String deviceVersion = "v88";
        Integer faceAttribute = 1;
        Integer livenessCheck = 1;
        String operatePerson = "4";
        String bkImageStorage = "1";

        DeviceCreateRequestBean deviceCreateRequestBean = new DeviceCreateRequestBean();
        deviceCreateRequestBean.setDeviceCnName(deviceCnName);
        deviceCreateRequestBean.setDeviceSerial(deviceSerial);
        deviceCreateRequestBean.setDeviceTag(deviceTag);
        deviceCreateRequestBean.setDeviceType(deviceType);
        deviceCreateRequestBean.setProductType(productType);
        deviceCreateRequestBean.setDeviceUri(deviceUri);
        deviceCreateRequestBean.setDeviceVersion(deviceVersion);
        deviceCreateRequestBean.setFaceAttribute(faceAttribute);
        deviceCreateRequestBean.setLivenessCheck(livenessCheck);
        deviceCreateRequestBean.setOperatePerson(operatePerson);
        deviceCreateRequestBean.setBkImageStorage(bkImageStorage);
        deviceCreateRequestBean.setDeviceIP(deviceIp);

        return new Object[][]{
                {"添加创建设备（genie-区域结构）",deviceCreateRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
