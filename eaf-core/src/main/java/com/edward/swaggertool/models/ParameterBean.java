package com.edward.swaggertool.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/15 18:14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParameterBean {
    private String name;
    private String in;
    private String descirption;
    private Boolean required;
    private String type;
}
