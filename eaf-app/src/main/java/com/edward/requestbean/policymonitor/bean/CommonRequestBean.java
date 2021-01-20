package com.edward.requestbean.policymonitor.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wangcheng
 * @date 2021/1/20 14:04
 */
@Data
public class CommonRequestBean {
    @ApiModelProperty(value = "限制告警策略Id", name = "policyId")
    private String policyId;
    @ApiModelProperty(value = "外部策略Id", name = "externalPolicyId")
    private String externalPolicyId;
    @ApiModelProperty(value = "限制告警策略名称", name = "policyName")
//    @NotBlank(message = "策略名称不能为空")
    private String policyName;
    @ApiModelProperty(value = "限制告警策略类型", name = "policyType")
//    @NotBlank(message = "策略类型不能为空")
    private String policyType;
    @ApiModelProperty(value = "操作列表", name = "policyActions")
//    @NotEmpty(message = "通知方式不能为空")
    private List<ActionBean> policyActions;
    @ApiModelProperty(value = "重复时间开始", name = "monitorPeriodStart")
    private String monitorPeriodStart;
    @ApiModelProperty(value = "重复时间结束", name = "monitorPeriodEnd")
    private String monitorPeriodEnd;
    @ApiModelProperty(value = "生效日期", name = "validPeriodStart")
    private String validPeriodStart;
    @ApiModelProperty(value = "失效日期", name = "validPeriodEnd")
    private String validPeriodEnd;
    @ApiModelProperty(value = "限制告警策略描述", name = "desc")
    private String desc;
    @ApiModelProperty(value = "属性组", name = "policyTargets")
    private List<TargetBean> policyTargets;
    @ApiModelProperty(value = "设备组", name = "policyDevices")
    private List<DeviceBean> policyDevices;
    @ApiModelProperty(value = "操作人", name = "operatePerson")
    private String operatePerson;
    @ApiModelProperty(value = "星期配置", name = "monitorPeriodWeekday")
    private String monitorPeriodWeekday;
    @ApiModelProperty(value = "部门ID", name = "privilege")
    private String privilege;
    @ApiModelProperty(value = "部门IDS", name = "privilege",hidden = true)
    private String[] deptIds;
    @ApiModelProperty(value = "状态", name = "sts")
    private String sts;
    @ApiModelProperty(value = "remark", name = "remark")
    private String remark;
}
