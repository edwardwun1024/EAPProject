package com.edward.requestbean.policymonitor.bean;

import lombok.Data;

import java.util.List;

/**
 * @author wangcheng
 * @date 2021/1/20 14:09
 */
@Data
public class RegionEntity {
    private String regionId;
    private String regionType;
    private String regionName;
    private String regionDef;
    private String regionDirection;
    private String roiIdentifier;
    private List<AppliedModelsEntity> appliedModels;
}
