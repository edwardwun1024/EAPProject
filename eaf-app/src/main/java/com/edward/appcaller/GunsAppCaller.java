package com.edward.appcaller;

import com.alibaba.fastjson.JSONObject;
import com.edward.app.AbstractServiceCaller;
import com.edward.common.CommonUtils;
import com.edward.http.HttpClientUtil;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.common.HttpMethods;
import com.edward.http.common.config.properties.EnvProperties;
import com.edward.http.exception.HttpProcessException;
import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;
import com.edward.requestbean.guns.bean.GunsAccountSetRoleRequestBean;
import com.edward.requestbean.guns.bean.GunsRoleTreeListByUserIdRequestBean;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.edward.requestbean.guns.bean.GunsMgrLoginRequestBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.xml.ws.spi.http.HttpContext;
import java.util.Map;

import static com.edward.app.GunsApp.*;

@Component
public class GunsAppCaller extends AbstractServiceCaller {

    @Resource
    private EnvProperties envProperties;


    public String getGunsMgrLogin(GunsMgrLoginRequestBean gunsMgrLoginRequestBean){
        return this.getPostgetGunsMgrLogin(super.getHttpConfig(),gunsMgrLoginRequestBean);
    }
    private String getPostgetGunsMgrLogin(HttpConfig httpConfig, GunsMgrLoginRequestBean gunsMgrLoginRequestBean){

//        System.out.println("EnvProperties:"+envProperties.getEvnIp());

        HttpHeader header = HttpHeader.custom();
        httpConfig.headers(header.build());

        httpConfig.method(HttpMethods.POST);
        httpConfig.url(host + POST_GUNS_MGR_LOGIN.path);
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
        return this.getGunsAccountAdd(super.getHttpConfig(),gunsAccountAddRequestBean);
    }
    private String getGunsAccountAdd(HttpConfig httpConfig, GunsAccountAddRequestBean gunsAccountAddRequestBean){

        HttpHeader header = HttpHeader.custom();
        header.authorization("Basic YWRtaW4sMDptZjZzM2M=");

        Map<String, Object> map=null;
        map = CommonUtils.transBean2Map(gunsAccountAddRequestBean);

        httpConfig.headers(header.build());
        httpConfig.method(HttpMethods.POST);
        httpConfig.url(host + POST_GUNS_ACCOUNT_ADD.path);
        httpConfig.map(map);

        String result = null;
        try {
            result = HttpClientUtil.post(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getGunsRoleTreeListByUserId(GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean){
        return this.getGunsRoleTreeListByUserId(super.getHttpConfig(),gunsRoleTreeListByUserIdRequestBean);
    }
    public String getGunsRoleTreeListByUserId(HttpConfig httpConfig, GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean){
        HttpHeader header = HttpHeader.custom();
        header.authorization("Basic YWRtaW4sMDpjbGF6aDQ=");

        Map<String, Object> map=null;
        map = CommonUtils.transBean2Map(gunsRoleTreeListByUserIdRequestBean);

        httpConfig.headers(header.build());
        httpConfig.method(HttpMethods.POST);
        httpConfig.url(host + POST_GUNS_ROLE_TREE_LIST_BY_USERID.getPath());
        httpConfig.map(map);

        String result = null;
        try {
            result = HttpClientUtil.post(httpConfig);
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getGunsAccountSetRole(GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean){
        return this.getGunsAccountSetRole(super.getHttpConfig(),gunsAccountSetRoleRequestBean);
    }
    public String getGunsAccountSetRole(HttpConfig httpConfig,GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean){
        HttpHeader header = HttpHeader.custom();
        header.authorization("Basic YWRtaW4sMDpyYTZteG4=");

        Map<String, Object> map=null;
        map = CommonUtils.transBean2Map(gunsAccountSetRoleRequestBean);

        httpConfig.headers(header.build());
        httpConfig.method(HttpMethods.POST);
        httpConfig.url(host + POST_GUNS_ACCOUNT_SETROLE.getPath());
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
