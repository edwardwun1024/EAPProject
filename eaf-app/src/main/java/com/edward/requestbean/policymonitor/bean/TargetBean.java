package com.edward.requestbean.policymonitor.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2021/1/20 14:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TargetBean {
    String targetId;
    String targetEnName;
    String targetCnName;
    String targetCnOption;
    String targetEnOption;
    String targetValue;
    String operator;
    String classId;
    String matchingThreshold;
}
