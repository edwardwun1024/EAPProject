package com.edward.scenario;

import com.edward.service.DeviceService;
import com.edward.service.GunsService;
import com.edward.service.PolicyMonitorService;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2021/1/20 17:47
 */
public class PolicyMonitorScenarioTest {
    @Test(description = "创建一个FilteringRuleMonitor")
    private void genFilteringRuleMonitor(){
        //1、登录账号
        GunsService gunsService = new GunsService();
        gunsService.loginStudioByAccount("admin","st#000000");
        //2、创建device
        String deviceCnName = "wc-region-99";
        String deviceSerial = "id-wc-region-99";
        String deviceTag = "qa";
        String deviceType = "21";
        String productType = "16";
        String deviceUri = "rtsp://admin:Sense123789456@10.151.23.99:554";
        String deviceIp = "10.151.23.99";
        String deviceVersion = "v88";
        String operatePerson = "4";
        String bkImageStorage = "1";
        DeviceService deviceService = new DeviceService();
        String returnDeviceId = deviceService.createDeviceByConditionWithRetunDeviceId(deviceCnName, deviceSerial, deviceTag, deviceType, productType, deviceUri, deviceIp, operatePerson,bkImageStorage,deviceVersion);

        //3、创建FilteringRuleMonitorPolicy
        String policyName = "wc-区域入侵-99";
        String deviceId = returnDeviceId;
        PolicyMonitorService policyMonitorService = new PolicyMonitorService();
        policyMonitorService.createFilteringRuleMonitorPolicyWithGenieRegionDevice(policyName,deviceId);

    }
}
