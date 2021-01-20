package com.edward.requestbean.policymonitor.bean;

import lombok.Data;

/**
 * @author wangcheng
 * @date 2021/1/20 14:10
 */
@Data
public class AppliedModelsEntity {
    private String modelID;
    private String modelName;
    private String modelFrequency;
    private String modelParameter;
    private String modelFrequencyType;
    private String remark;
}
