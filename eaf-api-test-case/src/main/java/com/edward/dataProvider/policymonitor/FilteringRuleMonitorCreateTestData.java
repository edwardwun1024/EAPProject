package com.edward.dataProvider.policymonitor;

import com.edward.PolicyDevices;
import com.edward.common.EnumCode;
import com.edward.requestbean.policymonitor.bean.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangcheng
 * @date 2021/1/20 14:28
 */
public class FilteringRuleMonitorCreateTestData {
    public Object[][] genFilteringRuleMonitorCreateTestData(){
        String policyName = "wc-区域入侵-02";

        List<DeviceBean> policyDevicesList = new ArrayList<DeviceBean>();
        String fight1_deviceId = "1352181136163344385";
        String fight1_deviceType = "21"; //21：区域结构摄像头  22：结构摄像头
        String tscar_deviceId = "1352181136163344385";
        String tscar_deviceType = "21"; //21：区域结构摄像头  22：结构摄像头
        DeviceBean deviceBean_1 = getDeviceBean(fight1_deviceId,fight1_deviceType);
        DeviceBean deviceBean_2 = getDeviceBean(tscar_deviceId,tscar_deviceType);
        policyDevicesList.add(deviceBean_1);
        policyDevicesList.add(deviceBean_2);

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

        //--------------appliedModels参数设置-3 --------------------
        AppliedModelsEntity appliedModelsEntity_fight1 = getAppliedModelsEntity("-2","harpyPCB","2","2"); //人车非
        AppliedModelsEntity appliedModelsEntity_tacars= getAppliedModelsEntity("-2","harpyPCB","2","2"); //人车非

        List<AppliedModelsEntity> appliedModelsEntityList_fight1 = getAppliedModelsEntityList(appliedModelsEntity_fight1);
        List<AppliedModelsEntity> appliedModelsEntityList_tscars = getAppliedModelsEntityList(appliedModelsEntity_tacars);

        //--------------roiList参数设置-2 --------------------
        String regionDef_fight1 = "[{\"x\":290.58240509033203,\"y\":181.9005889892578},{\"x\":224.58240509033203,\"y\":703.9005889892578},{\"x\":1010.582405090332,\"y\":922.9005889892578},{\"x\":1517.582405090332,\"y\":232.9005889892578},{\"x\":896.582405090332,\"y\":121.90058898925781},{\"x\":347.58240509033203,\"y\":151.9005889892578}]";
        String regionDef_tscars = "";
        RegionEntity regionEntity_fight1 = getRegionEntity(regionDef_fight1,appliedModelsEntityList_fight1);
        RegionEntity regionEntity_tscars = getRegionEntity(regionDef_tscars,appliedModelsEntityList_tscars);
        List<RegionEntity> regionEntityList_fight = getRegionEntityList(regionEntity_fight1);
        List<RegionEntity> regionEntityList_tacars = getRegionEntityList(regionEntity_tscars);

        //--------------monitorRoi参数设置-1 --------------------
        String fight1_regionPicUrl = "/images/cognitivesvc/20210121/ca64c90ca0d14c71a7036a649d26734c.jpg";
        String tscars_regionPicUrl = "/images/cognitivesvc/20210121/ccad76f6b5ac48978b98ee8f8c4cbccb.jpg";
        MonitorRoiEntity fight_monitorRoiEntity = getMonitorRoiEntity(fight1_deviceId,fight1_regionPicUrl,regionEntityList_fight);
        MonitorRoiEntity tscars_monitorRoiEntiry = getMonitorRoiEntity(tscar_deviceId,tscars_regionPicUrl,regionEntityList_tacars);

        List<MonitorRoiEntity> monitorRoiEntityList = new ArrayList<MonitorRoiEntity>();
        monitorRoiEntityList.add(fight_monitorRoiEntity);
        monitorRoiEntityList.add(tscars_monitorRoiEntiry);



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
