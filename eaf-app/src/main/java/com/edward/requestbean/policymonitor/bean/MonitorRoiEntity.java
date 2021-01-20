package com.edward.requestbean.policymonitor.bean;

import lombok.Data;

import java.util.List;

/**
 * @author wangcheng
 * @date 2021/1/20 14:09
 */
@Data
public class MonitorRoiEntity {
    private String did;
    private String regionPicUrl;
    private List<RegionEntity> roi;
    private String operatePerson;
    private String monitoringPolicyUuid;
}
