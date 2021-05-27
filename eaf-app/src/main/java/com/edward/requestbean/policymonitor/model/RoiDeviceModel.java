package com.edward.requestbean.policymonitor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangcheng
 * @date 2021/1/22 10:18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoiDeviceModel {
    private String deviceId;
    private String deviceType;
    private List<String> regionDefs;
    private String regionPicUrl;

}
