package com.edward.swaggertool.models.definitionsModel;

import com.google.gson.internal.LinkedTreeMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2021/1/4 17:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametersForRequestTypeValue {
    private String inType;
    private String name;
    private String description;
    private Boolean requried;
    private LinkedTreeMap<String,LinkedTreeMap<String,String>> schema;
}
