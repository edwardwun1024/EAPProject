package com.edward.requestbean.policymonitor.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangcheng
 * @date 2021/1/20 14:03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilteringRuleMonitorCreateRequestBean extends CommonRequestBean {
    @ApiModelProperty(value = "规则类型Id", name = "ruleTypeId")
    private String ruleTypeId;
    @ApiModelProperty(value = "设备计算方式", name = "deviceScope")
    private String deviceScope;
    @ApiModelProperty(value = "人员计算方式", name = "targetScope")
    private String targetScope;
    @ApiModelProperty(value = "触发条件时间DD:HH:MM", name = "rollingWindow")
    private String rollingWindow;
    @ApiModelProperty(value = "触发条件次数", name = "rollingCount")
    private String rollingCount;
    @ApiModelProperty(value = "frequency", name = "frequency")
    private String frequency;
    @ApiModelProperty(value = "事件跟踪级别", name = "eventTrackLevel")
    private String eventTrackLevel;
    @ApiModelProperty(value = "事件跟踪时间", name = "eventTrackTime")
    private String eventTrackTime;
    @ApiModelProperty(value = "事件跟踪频率时间", name = "eventTrackFreq")
    private String eventTrackFreq;
    @ApiModelProperty(value = "eventTriggerTime", name = "eventTriggerTime")
    private String eventTriggerTime;
    @ApiModelProperty(value = "操作人", name = "operatePerson")
    private String operatePerson;
    @ApiModelProperty(value = "告警区域信息", name = "monitoringRoi")
    private List<MonitorRoiEntity> monitoringRoi;
}
