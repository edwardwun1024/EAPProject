package com.edward.service;

import com.edward.appcaller.PolicyMonitorAppCaller;
import com.edward.common.EnumCode;
import com.edward.requestbean.policymonitor.bean.*;
import com.edward.responsebean.basic.BaseRes;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangcheng
 * @date 2021/1/20 17:48
 */
public class PolicyMonitorService extends BaseService {

    //创建FilteringRuleMonitor策略

    public void createFilteringRuleMonitorPolicyWithGenieRegionDevice(String policyName,String deviceId){

        List<DeviceBean> policyDevicesList = new ArrayList<DeviceBean>();
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
        String actionContent = "打架告警提醒"; //短信内容
        ActionBean actionBean = new ActionBean();
        actionBean.setActionTarget(actionTaget);
        actionBean.setActionType(actionType);
        actionBean.setActionContent(actionContent);
        actionBeanList.add(actionBean);

        List<TargetBean> targetBeanList = new ArrayList<TargetBean>();
        String targetId = "-3";
        String tagetValue = "1";
        String operator = "0";
        String classId = "up_0";
        TargetBean targetBean = new TargetBean();
        targetBean.setTargetId(targetId);
        targetBean.setTargetValue(tagetValue);
        targetBean.setOperator(operator);
        targetBean.setClassId(classId);
        targetBeanList.add(targetBean);

        String operatePerson = "0";
        String eventTrackLevel = null;
        String eventTrackTime = "-1";   //wrapper已经写死：-1
        String eventTrackFreq = "1000"; //wrapper已经写死：1000
        String remark = "{}";

        //--------------monitorRoi参数设置-1-start--------------------
        List<MonitorRoiEntity> monitorRoiEntityList = new ArrayList<MonitorRoiEntity>();
        //几乎全屏："/images/cognitivesvc/20210120/1556af27d35b4679ad777ef57fa061a8.jpg"
        String regionPicUrl = "/images/cognitivesvc/20210120/1556af27d35b4679ad777ef57fa061a8.jpg"; //99
        //String regionPicUrl = "/images/cognitivesvc/20210121/4d998adc8ada4ebf8593abfe0dc1bfaa.jpg";
        MonitorRoiEntity monitorRoiEntity = new MonitorRoiEntity();
        monitorRoiEntity.setOperatePerson(operatePerson);
        monitorRoiEntity.setDid(deviceId);
        monitorRoiEntity.setRegionPicUrl(regionPicUrl);

        //--------------roiList参数设置-2-start--------------------
        List<RegionEntity> regionEntityList = new ArrayList<RegionEntity>();
        String roiIdentifier = "";
        String regionName = "wc区域1";
        String regionDef = "[{\"x\":67.21045570086888,\"y\":35.50000214326437},{\"x\":59.276605412171165,\"y\":302.48314798859406},{\"x\":211.34206927887726,\"y\":323.63032785753103},{\"x\":330.34982360934293,\"y\":253.58029454167723},{\"x\":462.58066175430474,\"y\":327.59542408295675},{\"x\":537.952239496933,\"y\":252.25859579986866},{\"x\":552.4976316928788,\"y\":48.71698956134999},{\"x\":499.60529643489406,\"y\":13.0311235325188},{\"x\":399.1098594447231,\"y\":52.68208578677568},{\"x\":249.6890123409162,\"y\":16.996219757944488},{\"x\":178.28435974263684,\"y\":94.97644552464969},{\"x\":93.65662332986126,\"y\":19.639617241561613},{\"x\":69.85507246376812,\"y\":23.604713466987302},{\"x\":69.85507246376812,\"y\":23.604713466987302}]";
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

        String responseString = new PolicyMonitorAppCaller().getFilteringRuleMonitorCreate(filteringRuleMonitorCreateRequestBean);
        BaseRes createMonitorResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(createMonitorResponse.getCode(), EnumCode.BASE_SUCCESS.getCode());
    }

    //创建FilteringRuleMonitor策略 绑定两个设备
    public void createFilteringRuleMonitorPolicyWithGenieRegionWithMoreDevice(String policyName, List<DeviceBean> reqDeviceInfoList){

        String ruleTypeId = "4";
        String frequency = "2";
        String policyType = "8";
        String externalPolicyId = null;

        List<ActionBean> actionBeanList = new ArrayList<ActionBean>();
        ActionBean actionBean = getActionBean();
        actionBeanList.add(actionBean);

        List<TargetBean> targetBeanList = new ArrayList<TargetBean>();
        TargetBean targetBean = getTargetBean("-3","1","up_0");
        targetBeanList.add(targetBean);

        String operatePerson = "2";
        String eventTrackLevel = null;
        String eventTrackTime = null;
        String eventTrackFreq = null;
        String remark = "{}";


        List<DeviceBean> policyDevicesList = new ArrayList<DeviceBean>();
        List<MonitorRoiEntity> monitorRoiEntityList = new ArrayList<MonitorRoiEntity>();

        for (DeviceBean deviceBean:reqDeviceInfoList) {
            // ---处理策略中包含多个device------
            policyDevicesList.add(deviceBean);

            //--------------appliedModels参数设置-3 --------------------
            AppliedModelsEntity appliedModelsEntity = getAppliedModelsEntity("-2","harpyPCB","2","2"); //人车非
            List<AppliedModelsEntity> appliedModelsEntityList = new ArrayList<AppliedModelsEntity>();
            appliedModelsEntityList.add(appliedModelsEntity);

            //--------------roiList参数设置-2 --------------------
            String regionDef = "[{\"x\":290.58240509033203,\"y\":181.9005889892578},{\"x\":224.58240509033203,\"y\":703.9005889892578},{\"x\":1010.582405090332,\"y\":922.9005889892578},{\"x\":1517.582405090332,\"y\":232.9005889892578},{\"x\":896.582405090332,\"y\":121.90058898925781},{\"x\":347.58240509033203,\"y\":151.9005889892578}]";
            RegionEntity regionEntity = getRegionEntity(regionDef,appliedModelsEntityList);
            List<RegionEntity> regionEntityList = getRegionEntityList(regionEntity);
            //--------------monitorRoi参数设置-1 --------------------
            String regionPicUrl = "/images/cognitivesvc/20210121/ccad76f6b5ac48978b98ee8f8c4cbccb.jpg";
            MonitorRoiEntity fight_monitorRoiEntity = getMonitorRoiEntity(deviceBean.getDeviceId(),regionPicUrl,regionEntityList);
            monitorRoiEntityList.add(fight_monitorRoiEntity);

        }


        //---------装填requestBean------------
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

        String responseString = new PolicyMonitorAppCaller().getFilteringRuleMonitorCreate(filteringRuleMonitorCreateRequestBean);
        BaseRes createMonitorResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(createMonitorResponse.getCode(), EnumCode.BASE_SUCCESS.getCode());
        
    }




//---------------------------------------------------华丽的分割线--------------------------------------------------------
    
    public ActionBean getActionBean(){
        String actionTaget = "16602103425"; //手机号
        String actionType = "3"; //短信通知
        String actionContent = ""; //短信内容
        ActionBean actionBean = new ActionBean();
        actionBean.setActionTarget(actionTaget);
        actionBean.setActionType(actionType);
        actionBean.setActionContent(actionContent);
        return actionBean;
    }

    //全部人车非
    public TargetBean getTargetBean(String targetId,String targetValue,String classId){
        String operator = "2";
        TargetBean targetBean = new TargetBean();
        targetBean.setTargetId(targetId);
        targetBean.setTargetValue(targetValue);
        targetBean.setOperator(operator);
        targetBean.setClassId(classId);
        return targetBean;
    }

    public DeviceBean getDeviceBean(String deviceId, String deviceType){
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setDeviceId(deviceId);
        deviceBean.setDeviceType(deviceType);
        return deviceBean;
    }

    public RegionEntity getRegionEntity(String regionDef, List<AppliedModelsEntity> appliedModelsEntityList){
        String roiIdentifier = "";
        String regionName = "wc区域-"+getCurrentTime();
        String regionType = "0"; //0:区域 1：跨线
        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setRoiIdentifier(roiIdentifier);
        regionEntity.setRegionName(regionName);
        regionEntity.setRegionDef(regionDef);
        regionEntity.setRegionType(regionType);
        regionEntity.setAppliedModels(appliedModelsEntityList);
        return regionEntity;
    }

    public List<MonitorRoiEntity> getMonitorRoiEntityList(MonitorRoiEntity monitorRoiEntity){
        List<MonitorRoiEntity> monitorRoiEntityList = new ArrayList<MonitorRoiEntity>();
        monitorRoiEntityList.add(monitorRoiEntity);
        return monitorRoiEntityList;
    }

    public List<AppliedModelsEntity> getAppliedModelsEntityList(AppliedModelsEntity appliedModelsEntity){
        List<AppliedModelsEntity> appliedModelsEntityList = new ArrayList<AppliedModelsEntity>();
        appliedModelsEntityList.add(appliedModelsEntity);
        return appliedModelsEntityList;
    }

    public List<RegionEntity> getRegionEntityList(RegionEntity regionEntity){
        List<RegionEntity> regionEntityList = new ArrayList<RegionEntity>();
        regionEntityList.add(regionEntity);
        return regionEntityList;
    }

    public AppliedModelsEntity getAppliedModelsEntity(String modelID,String modelName,String modelFrequency,String modelFrequencyType){
        String modelParameter = "{\\\"threshold\\\":\\\"0.88\\\",\\\"minSize\\\":\\\"200\\\"}";
        AppliedModelsEntity appliedModelsEntity = new AppliedModelsEntity();
        appliedModelsEntity.setModelName(modelName);
        appliedModelsEntity.setModelID(modelID);
        appliedModelsEntity.setModelFrequency(modelFrequency);
        appliedModelsEntity.setModelFrequencyType(modelFrequencyType);
        appliedModelsEntity.setModelParameter(modelParameter);
        return appliedModelsEntity;
    }

    public MonitorRoiEntity getMonitorRoiEntity(String deviceId,String regionPicUrl,List<RegionEntity> regionEntityList){
        MonitorRoiEntity monitorRoiEntity = new MonitorRoiEntity();
        monitorRoiEntity.setOperatePerson("0");
        monitorRoiEntity.setDid(deviceId);
        monitorRoiEntity.setRegionPicUrl(regionPicUrl);
        monitorRoiEntity.setRoi(regionEntityList);
        return monitorRoiEntity;
    }

    public String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss-SSS"); //获取当前时间精确到毫秒
        return simpleDateFormat.format(new Date());
    }







}
