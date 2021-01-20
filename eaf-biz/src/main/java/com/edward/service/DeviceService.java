package com.edward.service;

import com.edward.appcaller.DeviceAppCaller;
import com.edward.common.EnumCode;
import com.edward.requestbean.device.bean.DeviceCreateRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.junit.Assert;

/**
 * @author wangcheng
 * @date 2021/1/20 18:02
 */
public class DeviceService extends BaseService{
    //创建device
    public void createDeviceByCondition(String deviceCnName, String deviceSerial, String deviceTag,String deviceType, String productType, String deviceUri, String deviceIp,String operatePerson,String bkImageStorage,String deviceVersion){
        Integer faceAttribute = 1;
        Integer livenessCheck = 1;

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

        String responseString = new DeviceAppCaller().getDeviceCreate(deviceCreateRequestBean);
        BaseRes createDeviceResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(createDeviceResponse.getCode(), EnumCode.BASE_SUCCESS.getCode());
    }

    public String createDeviceByConditionWithRetunDeviceId(String deviceCnName, String deviceSerial, String deviceTag,String deviceType, String productType, String deviceUri, String deviceIp,String operatePerson,String bkImageStorage,String deviceVersion){
        Integer faceAttribute = 1;
        Integer livenessCheck = 1;

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

        String responseString = new DeviceAppCaller().getDeviceCreate(deviceCreateRequestBean);
        BaseRes createDeviceResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(createDeviceResponse.getCode(), EnumCode.BASE_SUCCESS.getCode());
        String deviceId = createDeviceResponse.getData().toString();
        return deviceId;

    }

}
