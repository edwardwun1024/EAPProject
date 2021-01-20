package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

/**
 * @author wangcheng
 * @date 2021/1/20 11:05
 */
public class DeviceApp {
    public static final String  DEVICE_CREATE_PATH= "/DEVICE/device/create";
    public static final HttpApi POST_DEVICE_CREATE = new HttpApi(DEVICE_CREATE_PATH, HttpMethod.POST_JSON);

}
