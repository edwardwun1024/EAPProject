package com.edward.scenario;

import com.edward.requestbean.policymonitor.bean.DeviceBean;
import com.edward.service.DeviceService;
import com.edward.service.GunsService;
import com.edward.service.PolicyMonitorService;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcheng
 * @date 2021/1/20 17:47
 */
public class PolicyMonitorScenarioTest {
    @Test(description = "创建一个FilteringRuleMonitor-周界闯入")
    private void genFilteringRuleMonitorForRegionDevice(){
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
        //String deviceUri = "rtsp://10.151.5.84/wc1";
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

    @Test(description = "创建一个FilteringRuleMonitor-多个设备")
    private void genFilteringRuleMonitorForRegionDeviceWithMoreDevice(){
        //1、登录账号
        GunsService gunsService = new GunsService();
        gunsService.loginStudioByAccount("admin","st#000000");

        List<DeviceBean> deviceBeanList = new ArrayList<DeviceBean>();
        //2、创建device1
        String deviceCnName = "wc-device-fight1";
        String deviceSerial = "id-wc-device-fight1";
        String deviceTag = "qa";
        String deviceType = "22";
        String productType = "16";
        String deviceUri = "rtsp://10.151.5.84/fight1";
        String deviceIp = "10.151.5.84";
        String deviceVersion = "v88";
        String operatePerson = "4";
        String bkImageStorage = "1";
        DeviceService deviceService = new DeviceService();
        String returnDeviceId = deviceService.createDeviceByConditionWithRetunDeviceId(deviceCnName, deviceSerial, deviceTag, deviceType, productType, deviceUri, deviceIp, operatePerson,bkImageStorage,deviceVersion);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String deviceCnName1 = "wc-device-tscars";
        String deviceSerial1 = "id-wc-device-tscars";
        String deviceTag1 = "qa";
        String deviceType1 = "22";
        String productType1 = "16";
        String deviceUri1 = "rtsp://10.151.5.84/tscars";
        String deviceIp1 = "10.151.5.84";
        String deviceVersion1 = "v88";
        String operatePerson1 = "4";
        String bkImageStorage1 = "1";
        String returnDeviceId1 = deviceService.createDeviceByConditionWithRetunDeviceId(deviceCnName1, deviceSerial1, deviceTag1, deviceType1, productType1, deviceUri1, deviceIp1, operatePerson1,bkImageStorage1,deviceVersion1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DeviceBean deviceBean = new DeviceBean().builder().deviceId(returnDeviceId).deviceType("22").build();
        DeviceBean deviceBean1 = new DeviceBean().builder().deviceId(returnDeviceId1).deviceType("22").build();
        List<DeviceBean> deviceBeans = new ArrayList<DeviceBean>();
        deviceBeans.add(deviceBean);
        deviceBeans.add(deviceBean1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3、创建FilteringRuleMonitorPolicy
        String policyName = "wc-区域入侵-多个设备";
        PolicyMonitorService policyMonitorService = new PolicyMonitorService();
        policyMonitorService.createFilteringRuleMonitorPolicyWithGenieRegionWithMoreDevice(policyName,deviceBeans);

    }
}
