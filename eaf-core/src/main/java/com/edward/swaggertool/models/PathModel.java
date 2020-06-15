package com.edward.swaggertool.models;

import com.google.gson.internal.LinkedTreeMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/15 15:15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PathModel {
    private String url;
    private LinkedTreeMap<String,LinkedTreeMap> requestTypeModel;
}
