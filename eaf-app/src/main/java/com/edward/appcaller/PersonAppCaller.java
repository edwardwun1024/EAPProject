package com.edward.appcaller;

import com.alibaba.fastjson.JSONObject;
import com.edward.http.HttpClientUtil;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.common.HttpMethods;
import com.edward.http.exception.HttpProcessException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.edward.requestbean.person.PersonGroupListRequestBean;

public class PersonAppCaller {

    public CloseableHttpClient getClient(){
        return HttpClients.createDefault();
    }

    public String getPostPersonGroupList(PersonGroupListRequestBean personGroupListRequestBean){
        return this.getPostPersonGroupList(this.getClient(),personGroupListRequestBean);
    }
//    private String getPostPersonGroupList(CloseableHttpClient closeableHttpClient,PersonGroupListRequestBean personGroupListRequestBean){
//        return new HttpUtil().doPost(closeableHttpClient,PersonApp.POST_PERSON_GROUP_LIST_PATH,personGroupListRequestBean);
//    }

    private String getPostPersonGroupList(CloseableHttpClient closeableHttpClient,PersonGroupListRequestBean personGroupListRequestBean){
//        return new HttpUtil().doPost(closeableHttpClient,PersonApp.POST_PERSON_GROUP_LIST_PATH,personGroupListRequestBean);
        HttpHeader header = HttpHeader.custom();
        header.authorization("Basic d2FuZ2NoZW5nLDA6MWRqajhh");
        header.contentType("application/json;charset=UTF-8");

        HttpConfig httpConfig = HttpConfig.custom();
        httpConfig.headers(header.build());
        httpConfig.method(HttpMethods.POST);
        httpConfig.url("http://www.stg.intersense.sensetime.com/PERSON/personGroup/list");
        httpConfig.json(JSONObject.toJSONString(personGroupListRequestBean));
        String result = null;
        try {
             result = HttpClientUtil.post(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
        return result;
    }


}
