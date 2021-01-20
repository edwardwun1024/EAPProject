package com.edward.requestbean.policymonitor.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2021/1/20 14:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceBean {
    private String deviceId;
    private String deviceEnName;
    private String deviceCnName;
    private String deviceType;
    private String deviceSerial;
    private String importSource;
}
