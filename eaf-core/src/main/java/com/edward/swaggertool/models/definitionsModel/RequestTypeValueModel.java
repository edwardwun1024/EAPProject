package com.edward.swaggertool.models.definitionsModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author wangcheng
 * @date 2021/1/4 17:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestTypeValueModel {
    private ArrayList<String> tags;
    private String summary;
    private String operationId;
    private ArrayList<String> schemes;
    private ArrayList<String> consumes;
    private ArrayList<String> produces;
    private ParametersForRequestTypeValue parametersForRequestTypeValue;
    private ArrayList<String> responses;
    private ArrayList<String> security;
    private String type;
}
