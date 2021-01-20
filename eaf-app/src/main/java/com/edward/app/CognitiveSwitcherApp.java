package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

/**
 * @author wangcheng
 * @date 2021/1/20 16:57
 */
public class CognitiveSwitcherApp {
    public static final String  COGNITIVE_DEVICE_INFRA_FETCHFRAME_PATH= "/COGNITIVEXSWITCHER/cognitive/device/infra/fetchFrame";
    public static final HttpApi POST_COGNITIVE_DEVICE_INFRA_FETCHFRAME = new HttpApi(COGNITIVE_DEVICE_INFRA_FETCHFRAME_PATH, HttpMethod.POST_JSON);

}
