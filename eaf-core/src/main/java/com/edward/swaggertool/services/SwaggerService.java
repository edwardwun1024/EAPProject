package com.edward.swaggertool.services;

import com.edward.http.HttpApi;
import com.edward.http.HttpClientUtil;
import com.edward.http.HttpMethod;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.exception.HttpProcessException;
import com.edward.swaggertool.models.*;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangcheng
 * @date 2020/6/5 11:43
 */
public class SwaggerService {
    private String address;
    public static final String GET_SWAGGER_RESOURCES_PATH = "/swaggerresources";
    public static final HttpApi GET_SWAGGER_RESOURCES = new HttpApi(GET_SWAGGER_RESOURCES_PATH, HttpMethod.GET);


    public SwaggerService(String address) {
        this.address = address;
    }

    public List<SwaggerProjectModel> getAllProjects() {
        List<SwaggerProjectModel> projects = new ArrayList<>();
        String httpResponse = doGetBySwaggerResources(GET_SWAGGER_RESOURCES);
        List<SwaggerProjectModel> swaggerProjectModels =new Gson().fromJson(httpResponse,new TypeToken<List<SwaggerProjectModel>>(){}.getType());
        return swaggerProjectModels;
    }

    public  List<SwaggerApiModleForApp> getAllSwaggerProjectBean(List<SwaggerProjectModel> projectModelList) {
        List<SwaggerApiModleForApp> swaggerApiModleForApps = new ArrayList<>();
        //遍历每个project
        for(SwaggerProjectModel swaggerProjectModel:projectModelList){
            String response = doGetBySwaggerResources(new HttpApi(swaggerProjectModel.url,HttpMethod.GET));
            SwaggerProjectBean swaggerProjectBean = new Gson().fromJson(response,SwaggerProjectBean.class);

            //遍历每一个path
            ArrayList<PathModel> pathModels = new ArrayList<>();
            Map pathMap = swaggerProjectBean.getPaths();
            for(Object key : pathMap.keySet()){
                PathModel pathModel = new PathModel();
                pathModel.setUrl(key.toString());
                pathModel.setRequestTypeModel((LinkedTreeMap<String, LinkedTreeMap>) pathMap.get(key));
                pathModels.add(pathModel);
            }

            List<RequestTypeModel> requestTypeModelList = new ArrayList<>();
            //遍历每一个path的requestType值
            for (PathModel pathModel : pathModels){
                String url = pathModel.getUrl();
                Map requestTypeMap = pathModel.getRequestTypeModel();
                //封装成RequestTypeModel类，并加到List集合中
                for(Object key : requestTypeMap.keySet()){
                    RequestTypeModel requestTypeModel = new RequestTypeModel();
                    requestTypeModel.setUrl(url);
                    requestTypeModel.setRequeType(key.toString());
                    requestTypeModel.setRequestTypeValue((LinkedTreeMap<String, Object>) requestTypeMap.get(key));
                    requestTypeModelList.add(requestTypeModel);
                }
            }

            List<ApiModle> apiModles = new ArrayList<>();
            //封装成SwaggerProjectModelPathBean
            for(RequestTypeModel requestTypeModel : requestTypeModelList){
                SwaggerProjectModelPathBean swaggerProjectModelPathBean = new SwaggerProjectModelPathBean();
                swaggerProjectModelPathBean.setTags((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("tags"));;
                swaggerProjectModelPathBean.setSummary((String) requestTypeModel.getRequestTypeValue().get("summary"));
                swaggerProjectModelPathBean.setOperationId((String) requestTypeModel.getRequestTypeValue().get("operationId"));
                swaggerProjectModelPathBean.setSchemes((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("schemes"));
                swaggerProjectModelPathBean.setConsumes((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("consumes"));
                swaggerProjectModelPathBean.setProduces((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("produces"));
                swaggerProjectModelPathBean.setParameters((ArrayList<LinkedTreeMap>) requestTypeModel.getRequestTypeValue().get("parameters"));
                swaggerProjectModelPathBean.setResponses((LinkedTreeMap<String, LinkedTreeMap<String, LinkedTreeMap>>) requestTypeModel.getRequestTypeValue().get("responses"));
                swaggerProjectModelPathBean.setSecurity((ArrayList<String>) requestTypeModel.getRequestTypeValue().get("security"));
                swaggerProjectModelPathBean.setType((String) requestTypeModel.getRequestTypeValue().get("type"));

                ApiModle apiModle = new ApiModle();
                apiModle.setUrl(requestTypeModel.getUrl());
                apiModle.setRequestType(requestTypeModel.getRequeType());
                apiModle.setSwaggerProjectModelPathBean(swaggerProjectModelPathBean);

                apiModles.add(apiModle);

            }

            //生成每个app对应的apimodel
            SwaggerApiModleForApp swaggerApiModleForApp = new SwaggerApiModleForApp();
            swaggerApiModleForApp.setAppName(swaggerProjectModel.name);
            swaggerApiModleForApp.setApiModles(apiModles);

            //将所有的SwaggerApiModleForApp装到list中，并返回
            swaggerApiModleForApps.add(swaggerApiModleForApp);
        }

        return swaggerApiModleForApps;
    }

    public String doGetBySwaggerResources(HttpApi httpApi){
        HttpHeader header = HttpHeader.custom();
        HttpConfig httpConfig = HttpConfig.custom();

        httpConfig.method(httpApi.httpMethod.getHttpMethods());
        httpConfig.url(address + httpApi.path);

        String response = null;
        try {
            response = HttpClientUtil.get(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }

        return response;

    }



}
