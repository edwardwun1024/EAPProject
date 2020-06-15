package com.edward.swaggertool.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangcheng
 * @date 2020/6/5 11:34
 */
public class SwaggerItemModel {
    public String projectName;
    public String methodName;
    public String url;
    public String rawUrl;

    public Map<String, String> headers = new HashMap<>();
    public Map<String, String> paths = new HashMap<>();
    public Map<String, String> queries = new HashMap<>();
}
