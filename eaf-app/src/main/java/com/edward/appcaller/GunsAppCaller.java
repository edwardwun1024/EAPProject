package com.edward.appcaller;

import com.alibaba.fastjson.JSONObject;
import com.edward.app.AbstractServiceCaller;
import com.edward.common.CommonUtils;
import com.edward.common.EnumCode;
import com.edward.http.HttpApi;
import com.edward.http.HttpClientUtil;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.common.HttpMethods;
import com.edward.http.common.config.properties.EnvProperties;
import com.edward.http.exception.HttpProcessException;
import com.edward.requestbean.guns.bean.GunsAccountAddRequestBean;
import com.edward.requestbean.guns.bean.GunsAccountSetRoleRequestBean;
import com.edward.requestbean.guns.bean.GunsRoleTreeListByUserIdRequestBean;
import com.edward.responsebean.basic.BaseRes;
import com.google.gson.Gson;
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

    public static HttpHeader header = HttpHeader.custom();
    public static HttpConfig httpConfig = HttpConfig.custom();

//    @Resource
//    private EnvProperties envProperties;


    public String getGunsMgrLogin(GunsMgrLoginRequestBean gunsMgrLoginRequestBean){
        return this.getPostgetGunsMgrLogin(POST_GUNS_MGR_LOGIN,gunsMgrLoginRequestBean);
    }
    private String getPostgetGunsMgrLogin(HttpApi POST_GUNS_MGR_LOGIN, GunsMgrLoginRequestBean gunsMgrLoginRequestBean){
        return doPost(POST_GUNS_MGR_LOGIN,gunsMgrLoginRequestBean);
    }

    public String getGunsAccountAdd(GunsAccountAddRequestBean gunsAccountAddRequestBean, String authorization){
        return this.getGunsAccountAdd(POST_GUNS_ACCOUNT_ADD,gunsAccountAddRequestBean, authorization);
    }
    private String getGunsAccountAdd(HttpApi POST_GUNS_ACCOUNT_ADD, GunsAccountAddRequestBean gunsAccountAddRequestBean, String authorization){
        return doPost(POST_GUNS_ACCOUNT_ADD,gunsAccountAddRequestBean);
    }

    public String getGunsRoleTreeListByUserId(GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean, String authorization){
        return this.getGunsRoleTreeListByUserId(POST_GUNS_ROLE_TREE_LIST_BY_USERID,gunsRoleTreeListByUserIdRequestBean, authorization);
    }
    private String getGunsRoleTreeListByUserId(HttpApi POST_GUNS_ROLE_TREE_LIST_BY_USERID, GunsRoleTreeListByUserIdRequestBean gunsRoleTreeListByUserIdRequestBean, String authorization){
        return doPost(POST_GUNS_ROLE_TREE_LIST_BY_USERID, gunsRoleTreeListByUserIdRequestBean);
    }

    public String getGunsAccountSetRole(GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean, String authorization){
        return this.getGunsAccountSetRole(POST_GUNS_ACCOUNT_SETROLE,gunsAccountSetRoleRequestBean, authorization);
    }
    public String getGunsAccountSetRole(HttpApi POST_GUNS_ROLE_TREE_LIST_BY_USERID,GunsAccountSetRoleRequestBean gunsAccountSetRoleRequestBean, String authorization){
        return doPost(POST_GUNS_ACCOUNT_SETROLE,gunsAccountSetRoleRequestBean);
    }



    public String doPost(HttpApi httpApi, Object object){
//        //设置header
//        if(header.authorization() != null){
//            httpConfig.headers(header.build());
//        }


        httpConfig.method(httpApi.httpMethod.getHttpMethods());
        httpConfig.url(host + httpApi.path);

        //适配post请求类型不同bodytype
        switch (httpApi.httpMethod){
            case POST_JSON:
                String jsonString = JSONObject.toJSONString(object);
                httpConfig.json(jsonString);
                break;

            case POST_FROM:
                Map<String, Object> map = CommonUtils.transBean2Map(object);
                httpConfig.map(map);
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
                    header.authorization("Base " + baseRes.getData().toString());
                }
            }
        }
        return result;
    }

}
