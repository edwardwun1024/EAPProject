package com.edward.swaggertool.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020/6/15 16:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwaggerApiModleForApp {
    private String appName;
    private List<ApiModle> apiModles;

}
