package com.edward.swaggertool.models;


import com.google.gson.internal.LinkedTreeMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangcheng
 * @date 2020/6/5 18:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwaggerProjectBean<T> implements Serializable {
    private String swagger;
    private Object info;
    private String host;
    private String basePath;
    private List<Object> tags;
    private List<Object> schemes;
    private List<Object> consumes;
    private List<Object> produces;
    private LinkedTreeMap<String,LinkedTreeMap> paths;
    private Object securityDefinitions;
//    private Object definitions;
    private T definitions;

}
