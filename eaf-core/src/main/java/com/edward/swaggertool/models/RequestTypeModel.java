package com.edward.swaggertool.models;

import com.edward.swaggertool.models.definitionsModel.RequestTypeValueModel;
import com.google.gson.internal.LinkedTreeMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/6/15 15:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestTypeModel {
    private String url;
    private String requeType;
    private LinkedTreeMap<String,Object> requestTypeValue;
    // private RequestTypeValueModel requestTypeValueModel;
}
