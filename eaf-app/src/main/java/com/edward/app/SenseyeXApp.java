package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

/**
 * @author wangcheng
 * @date 2021/1/20 16:57
 */
public class SenseyeXApp {
    public static final String  SENSEYEX_MGMT_RTSP_V1_SET_RTSP_DEVICE_PATH= "/SENSEYEX/senseyex/mgmt/rtsp/v1/set_rtsp_device";
    public static final HttpApi POST_SENSEYEX_MGMT_RTSP_V1_SET_RTSP_DEVICE = new HttpApi(SENSEYEX_MGMT_RTSP_V1_SET_RTSP_DEVICE_PATH, HttpMethod.POST_JSON);

}
