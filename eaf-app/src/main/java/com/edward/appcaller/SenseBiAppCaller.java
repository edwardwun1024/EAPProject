package com.edward.appcaller;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author wangcheng
 * @date 2020/4/20 11:21
 */
public class SenseBiAppCaller {
    public CloseableHttpClient getClient(){
        return HttpClients.createDefault();
    }
}
