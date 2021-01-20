package com.edward.appcaller;

import com.edward.http.HttpApi;
import com.edward.requestbean.device.bean.DeviceCreateRequestBean;

import static com.edward.app.DeviceApp.POST_DEVICE_CREATE;

/**
 * @author wangcheng
 * @date 2021/1/20 11:05
 */
public class DeviceAppCaller extends AbstractServiceCaller {

    public String getDeviceCreate(DeviceCreateRequestBean gunsMgrLoginRequestBean){
        return this.getPostGetDeviceCreate(POST_DEVICE_CREATE,gunsMgrLoginRequestBean);
    }
    private String getPostGetDeviceCreate(HttpApi POST_DEVICE_CREATE, DeviceCreateRequestBean gunsMgrLoginRequestBean){
        return doPost(POST_DEVICE_CREATE,gunsMgrLoginRequestBean);
    }



}
