package com.edward.swaggertool.models;

import com.google.gson.internal.LinkedTreeMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author wangcheng
 * @date 2020/6/15 14:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwaggerProjectModelPathBean {
    private ArrayList<String> tags;   //batch-import-task-controller
    private String summary;           //删除批量导入task
    private String operationId;
    private ArrayList<String> schemes;
    private ArrayList<String> consumes;  //application/json
    private ArrayList<String> produces;
    private ArrayList<LinkedTreeMap> parameters;
    private LinkedTreeMap<String,LinkedTreeMap<String, LinkedTreeMap>> responses;
    private ArrayList<String> security;
    private String type;
}
