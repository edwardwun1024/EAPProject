package com.edward.appcaller;

import com.edward.http.HttpApi;
import com.edward.requestbean.policymonitor.bean.FilteringRuleMonitorCreateRequestBean;

import static com.edward.app.PolicyMonitorApp.POST_POLICYMONITOR_FILTERINGRULEMONITORINGPOLICY_CREATE;

/**
 * @author wangcheng
 * @date 2021/1/20 14:12
 */
public class PolicyMonitorAppCaller extends AbstractServiceCaller {
    public String getFilteringRuleMonitorCreate(FilteringRuleMonitorCreateRequestBean filteringRuleMonitorCreateRequestBean){
        return this.getPostGetFilteringRuleMonitorCreate(POST_POLICYMONITOR_FILTERINGRULEMONITORINGPOLICY_CREATE,filteringRuleMonitorCreateRequestBean);
    }
    private String getPostGetFilteringRuleMonitorCreate(HttpApi POST_POLICYMONITOR_FILTERINGRULEMONITORINGPOLICY_CREATE, FilteringRuleMonitorCreateRequestBean filteringRuleMonitorCreateRequestBean){
        return doPost(POST_POLICYMONITOR_FILTERINGRULEMONITORINGPOLICY_CREATE,filteringRuleMonitorCreateRequestBean);
    }
}
