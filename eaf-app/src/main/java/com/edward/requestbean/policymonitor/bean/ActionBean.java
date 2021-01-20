package com.edward.requestbean.policymonitor.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2021/1/20 14:05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionBean {
    private String actionType;
    private String actionTarget;
    private String actionContent;
}
