package com.edward.appcaller;

import com.edward.http.HttpApi;
import com.edward.requestbean.cognitiveswitcher.bean.CognitiveDeviceInfraFetchFrameRequestBean;

import static com.edward.app.CognitiveSwitcherApp.POST_COGNITIVE_DEVICE_INFRA_FETCHFRAME;

/**
 * @author wangcheng
 * @date 2021/1/20 16:57
 */
public class CognitiveSwitcherAppCaller extends AbstractServiceCaller{
    public String getCognitiveDeviceInfraFetchFrame(CognitiveDeviceInfraFetchFrameRequestBean cognitiveDeviceInfraFetchFrameRequestBean){
        return this.getPostGetCognitiveDeviceInfraFetchFrame(POST_COGNITIVE_DEVICE_INFRA_FETCHFRAME,cognitiveDeviceInfraFetchFrameRequestBean);
    }
    private String getPostGetCognitiveDeviceInfraFetchFrame(HttpApi POST_COGNITIVE_DEVICE_INFRA_FETCHFRAME, CognitiveDeviceInfraFetchFrameRequestBean cognitiveDeviceInfraFetchFrameRequestBean){
        return doPost(POST_COGNITIVE_DEVICE_INFRA_FETCHFRAME,cognitiveDeviceInfraFetchFrameRequestBean);
    }
}
