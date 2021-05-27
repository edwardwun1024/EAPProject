package com.edward.Base;

import com.edward.service.PolicyMonitorService;

/**
 * @author wangcheng
 * @date 2021/1/22 11:47
 */
public class BaseScenarioTest {

    public static PolicyMonitorService getPolicyMonitorService() {
        PolicyMonitorService policyMonitorService = new PolicyMonitorService();
        return policyMonitorService;
    }

    public void getTreadSleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
