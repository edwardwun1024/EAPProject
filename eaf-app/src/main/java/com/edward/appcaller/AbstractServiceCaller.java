package com.edward.appcaller;

import com.alibaba.fastjson.JSONObject;
import com.edward.common.CommonUtils;
import com.edward.common.EnumCode;
import com.edward.http.HttpApi;
import com.edward.http.HttpClientUtil;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.common.Utils;
import com.edward.http.common.util.PropertiesUtil;
import com.edward.http.exception.HttpProcessException;
import com.edward.responsebean.basic.BaseRes;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Properties;

import static com.edward.app.GunsApp.GUNS_MGR_LOGIN_PATH;

/**
 * 抽象类，提供post和get抽象方法
 */
public class AbstractServiceCaller{


    public static String host = "http://studio202/";
    public static String token = "";




    public abstract interface doPost{};

    public String doPost(HttpApi httpApi, Object object){
        PropertiesUtil properties = new PropertiesUtil();
        HttpHeader header = HttpHeader.custom();
        HttpConfig httpConfig = HttpConfig.custom();
        httpConfig.httpApi(httpApi);
        //设置header
        if(token != null){
            header.authorization(token);
            httpConfig.headers(header.build());
        }

        httpConfig.method(httpConfig.httpApi().httpMethod.getHttpMethods());
        httpConfig.url(host + httpApi.path);

        //适配post请求类型不同bodytype
        switch (httpConfig.httpApi().httpMethod){
            case POST_JSON:
                String jsonString = JSONObject.toJSONString(object);
                httpConfig.json(jsonString);
                break;

            case POST_FORM:
                Map<String, Object> map = CommonUtils.transBean2Map(object);
                httpConfig.map(map);
                break;

            case POST_FILE:
                Map<String, Object> mapFileParameter = CommonUtils.transBean2Map(object);
                httpConfig.files(mapFileParameter);
                break;
            case POST_PARAM:
                Map<String, Object> paramsMap = CommonUtils.transBean2Map(object);
                httpConfig.params(paramsMap);
                break;

        }

        String result = null;
        try {
            result = HttpClientUtil.post(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }finally {
            //如果调的是登陆接口，获取返回token装填到静态的header中方便场景case后续接口使用
            if(httpApi.getPath() == GUNS_MGR_LOGIN_PATH){
                BaseRes baseRes = new Gson().fromJson(result, BaseRes.class);
                if(baseRes.getCode().equals(EnumCode.BASE_SUCCESS.getCode())){
                    token = "Basic " + baseRes.getData().toString();
                }
            }
        }
        return result;
    }



}
