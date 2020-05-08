package com.edward.appcaller;

import com.alibaba.fastjson.JSONObject;
import com.edward.app.AbstractServiceCaller;
import com.edward.common.CommonUtils;
import com.edward.http.HttpClientUtil;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.common.HttpMethods;
import com.edward.http.exception.HttpProcessException;
import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.edward.requestbean.guns.bean.GunsMgrLoginRequestBean;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.edward.app.GunsApp.GUNS_ACCOUNT_ADD_PATH;
import static com.edward.app.GunsApp.GUNS_MGR_LOGIN_PATH;

@Component
public class GunsAppCaller extends AbstractServiceCaller {
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
        httpConfig.url("http://studio80"+GUNS_MGR_LOGIN_PATH);
        httpConfig.json(JSONObject.toJSONString(gunsMgrLoginRequestBean));
        String result = null;
        try {
            result = HttpClientUtil.post(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getGunsAccountAdd(GunsAccountAddRequestBean gunsAccountAddRequestBean){
        return this.getGunsAccountAdd(this.getClient(),gunsAccountAddRequestBean);
    }
    private String getGunsAccountAdd(CloseableHttpClient closeableHttpClient, GunsAccountAddRequestBean gunsAccountAddRequestBean){

        HttpHeader header = HttpHeader.custom();
        header.contentType("application/x-www-form-urlencoded; charset=utf-8");
        header.authorization("Basic d2FuZ2NoZW5nLDA6ZTl0dHJs");

        Map<String, Object> map=null;
        map = CommonUtils.transBean2Map(gunsAccountAddRequestBean);

        HttpConfig httpConfig = HttpConfig.custom();
        httpConfig.headers(header.build());
        httpConfig.method(HttpMethods.POST);
        httpConfig.url("http://studio80"+GUNS_ACCOUNT_ADD_PATH);
        httpConfig.map(map);

        String result = null;
        try {
            result = HttpClientUtil.post(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
        return result;
    }


}
