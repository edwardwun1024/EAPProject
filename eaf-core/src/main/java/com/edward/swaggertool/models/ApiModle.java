package com.edward.swaggertool.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/15 17:33
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiModle {
    private String url;
    private String requestType;
    private SwaggerProjectModelPathBean swaggerProjectModelPathBean;
}
