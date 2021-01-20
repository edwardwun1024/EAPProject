package com.edward.dataProvider.policymonitor;

import com.edward.PolicyDevices;
import com.edward.common.EnumCode;
import com.edward.requestbean.policymonitor.bean.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangcheng
 * @date 2021/1/20 14:28
 */
public class FilteringRuleMonitorCreateTestData {
    public Object[][] genFilteringRuleMonitorCreateTestData(){
        String policyName = "wc-区域入侵-02";

        List<DeviceBean> policyDevicesList = new ArrayList<DeviceBean>();
        String deviceId = "1351724885386203137";
        String deviceType = "21";  //21：区域结构摄像头  22：结构摄像头
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setDeviceId(deviceId);
        deviceBean.setDeviceType(deviceType);
        policyDevicesList.add(deviceBean);

        String ruleTypeId = "4";
        String frequency = "2";
        String policyType = "8";
        String externalPolicyId = null;

        List<ActionBean> actionBeanList = new ArrayList<ActionBean>();
        String actionTaget = "16602103425"; //手机号
        String actionType = "3"; //短信通知
        String actionContent = "有人闯入"; //短信内容
        ActionBean actionBean = new ActionBean();
        actionBean.setActionTarget(actionTaget);
        actionBean.setActionType(actionType);
        actionBean.setActionContent(actionContent);
        actionBeanList.add(actionBean);

        List<TargetBean> targetBeanList = new ArrayList<TargetBean>();
        String targetId = "-3";
        String tagetValue = "1";
        String operator = "2";
        String classId = "up_0";
        TargetBean targetBean = new TargetBean();
        targetBean.setTargetId(targetId);
        targetBean.setTargetValue(tagetValue);
        targetBean.setOperator(operator);
        targetBean.setClassId(classId);
        targetBeanList.add(targetBean);

        String operatePerson = "2";
        String eventTrackLevel = null;
        String eventTrackTime = null;
        String eventTrackFreq = null;
        String remark = "{}";

        //--------------monitorRoi参数设置-1-start--------------------
        List<MonitorRoiEntity> monitorRoiEntityList = new ArrayList<MonitorRoiEntity>();
        //几乎全屏："/images/cognitivesvc/20210120/1556af27d35b4679ad777ef57fa061a8.jpg"
        String regionPicUrl = "/images/cognitivesvc/20210120/cbca37d8f28347c4970a9b15d3c2be93.jpg";
        MonitorRoiEntity monitorRoiEntity = new MonitorRoiEntity();
        monitorRoiEntity.setOperatePerson(operatePerson);
        monitorRoiEntity.setDid(deviceId);
        monitorRoiEntity.setRegionPicUrl(regionPicUrl);

        //--------------roiList参数设置-2-start--------------------
        List<RegionEntity> regionEntityList = new ArrayList<RegionEntity>();
        String roiIdentifier = "";
        String regionName = "wc区域1";
        String regionDef = "[{\"x\":290.58240509033203,\"y\":181.9005889892578},{\"x\":224.58240509033203,\"y\":703.9005889892578},{\"x\":1010.582405090332,\"y\":922.9005889892578},{\"x\":1517.582405090332,\"y\":232.9005889892578},{\"x\":896.582405090332,\"y\":121.90058898925781},{\"x\":347.58240509033203,\"y\":151.9005889892578}]";
        String regionType = "0";
        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setRoiIdentifier(roiIdentifier);
        regionEntity.setRegionName(regionName);
        regionEntity.setRegionDef(regionDef);
        regionEntity.setRegionType(regionType);


        //--------------appliedModels参数设置-3-start--------------------
        //AppliedModelsEntity如果为空，自动生成一个随机数
        List<AppliedModelsEntity> appliedModelsEntityList = new ArrayList<AppliedModelsEntity>();
        String modelID = "-2";
        String modelName = "harpyPCB";
        String modelFrequency = "2";
        String modelFrequencyType = "2";
        String modelParameter = "{\\\"threshold\\\":\\\"0.88\\\",\\\"minSize\\\":\\\"200\\\"}";
        AppliedModelsEntity appliedModelsEntity = new AppliedModelsEntity();
        appliedModelsEntity.setModelName(modelName);
        appliedModelsEntity.setModelID(modelID);
        appliedModelsEntity.setModelFrequency(modelFrequency);
        appliedModelsEntity.setModelFrequencyType(modelFrequencyType);
        appliedModelsEntity.setModelParameter(modelParameter);
        appliedModelsEntityList.add(appliedModelsEntity);
        //--------------appliedModels参数设置-3-end--------------------

        regionEntity.setAppliedModels(appliedModelsEntityList);
        regionEntityList.add(regionEntity);
        //--------------roiList参数设置-2-end--------------------

        monitorRoiEntity.setRoi(regionEntityList);
        monitorRoiEntityList.add(monitorRoiEntity);
        //--------------monitorRoi参数设置-1-end--------------------

        FilteringRuleMonitorCreateRequestBean filteringRuleMonitorCreateRequestBean = new FilteringRuleMonitorCreateRequestBean();
        filteringRuleMonitorCreateRequestBean.setPolicyName(policyName);
        filteringRuleMonitorCreateRequestBean.setPolicyDevices(policyDevicesList);
        filteringRuleMonitorCreateRequestBean.setRuleTypeId(ruleTypeId);
        filteringRuleMonitorCreateRequestBean.setFrequency(frequency);
        filteringRuleMonitorCreateRequestBean.setPolicyType(policyType);
        filteringRuleMonitorCreateRequestBean.setExternalPolicyId(externalPolicyId);
        filteringRuleMonitorCreateRequestBean.setPolicyActions(actionBeanList);
        filteringRuleMonitorCreateRequestBean.setPolicyTargets(targetBeanList);
        filteringRuleMonitorCreateRequestBean.setOperatePerson(operatePerson);
        filteringRuleMonitorCreateRequestBean.setEventTrackLevel(eventTrackLevel);
        filteringRuleMonitorCreateRequestBean.setEventTrackTime(eventTrackTime);
        filteringRuleMonitorCreateRequestBean.setEventTrackFreq(eventTrackFreq);
        filteringRuleMonitorCreateRequestBean.setRemark(remark);
        filteringRuleMonitorCreateRequestBean.setMonitoringRoi(monitorRoiEntityList);

        return new Object[][]{
                {"创建规则过滤告警策略（区域入侵）",filteringRuleMonitorCreateRequestBean, EnumCode.BASE_SUCCESS}
        };
    }


    /**打架
     * modelFrequency: "8"
     * modelID: "1348896282378244097"
     * modelName: "falconLiteClimbTumble"
     * modelParameter: "{"threshold":"0.88","minSize":"200"}"
     */


}
