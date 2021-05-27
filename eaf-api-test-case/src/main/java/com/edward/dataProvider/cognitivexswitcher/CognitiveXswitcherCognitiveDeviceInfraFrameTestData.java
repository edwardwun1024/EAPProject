package com.edward.dataProvider.cognitivexswitcher;

import com.edward.common.EnumCode;

/**
 * @author wangcheng
 * @date 2021/1/26 15:41
 */
public class CognitiveXswitcherCognitiveDeviceInfraFrameTestData {
    public Object[][] genCognitiveXswitcherCognitiveDeviceInfraFrameTestData() {
        String rtsp = "rtsp://10.151.5.84/fight1";
        return new Object[][]{
                {"获取流的一帧", rtsp, EnumCode.BASE_SUCCESS}
        };
    }
}
