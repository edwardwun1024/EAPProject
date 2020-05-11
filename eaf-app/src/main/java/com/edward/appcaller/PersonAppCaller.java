package com.edward.appcaller;

import com.alibaba.fastjson.JSONObject;
import com.edward.app.AbstractServiceCaller;
import com.edward.http.HttpClientUtil;
import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;
import com.edward.http.common.HttpMethods;
import com.edward.http.exception.HttpProcessException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.edward.requestbean.person.bean.PersonGroupListRequestBean;

import static com.edward.app.PersonApp.POST_PERSON_GROUP_LIST;

public class PersonAppCaller extends AbstractServiceCaller {


    public String getPostPersonGroupList(PersonGroupListRequestBean personGroupListRequestBean){
        return this.getPostPersonGroupList(super.getHttpConfig(),personGroupListRequestBean);
    }

    private String getPostPersonGroupList(HttpConfig httpConfig,PersonGroupListRequestBean personGroupListRequestBean){
        HttpHeader header = HttpHeader.custom();
        header.authorization("Basic YWRtaW4sMDppYjJ2anc");

        httpConfig.headers(header.build());
        httpConfig.method(HttpMethods.POST);
        httpConfig.url(host + POST_PERSON_GROUP_LIST.getPath());
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
