package com.edward.appcaller;

import com.alibaba.fastjson.JSONObject;
import com.edward.http.HttpClientUtil;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.common.HttpMethods;
import com.edward.http.exception.HttpProcessException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.edward.requestbean.guns.bean.GunsMgrLoginRequestBean;

public class GunsAppCaller {
    public CloseableHttpClient getClient(){
        return HttpClients.createDefault();
    }

    public String getGunsMgrLogin(GunsMgrLoginRequestBean gunsMgrLoginRequestBean){
        return this.getPostgetGunsMgrLogin(this.getClient(),gunsMgrLoginRequestBean);
    }
    private String getPostgetGunsMgrLogin(CloseableHttpClient closeableHttpClient,GunsMgrLoginRequestBean gunsMgrLoginRequestBean){
        HttpHeader header = HttpHeader.custom();
        header.contentType("application/json;charset=UTF-8");

        HttpConfig httpConfig = HttpConfig.custom();
        httpConfig.headers(header.build());
        httpConfig.method(HttpMethods.POST);
        httpConfig.url("http://www.stg.intersense.sensetime.com/GUNS/mgr/login");
        httpConfig.json(JSONObject.toJSONString(gunsMgrLoginRequestBean));
        String result = null;
        try {
            result = HttpClientUtil.post(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
