package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

/**
 * @author wangcheng
 * @date 2021/1/20 14:13
 */
public class PolicyMonitorApp {
    public static final String  POLICYMONITOR_FILTERINGRULEMONITORINGPOLICY_CREATE_PATH= "/POLICYMONITOR/filteringRuleMonitoringPolicy/create";
    public static final HttpApi POST_POLICYMONITOR_FILTERINGRULEMONITORINGPOLICY_CREATE = new HttpApi(POLICYMONITOR_FILTERINGRULEMONITORINGPOLICY_CREATE_PATH, HttpMethod.POST_JSON);

}
