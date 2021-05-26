package com.edward.app.policymonitor;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.PolicyMonitorAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.policymonitor.FilteringRuleMonitorCreateTestData;
import com.edward.requestbean.policymonitor.bean.FilteringRuleMonitorCreateRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2021/1/20 14:31
 */
public class FilteringRuleMonitorCreateTest extends BaseApiTest {
    @DataProvider(name = "dataPrdGetFilteringRuleMonitorCreateTest")
    public Object[][] getDataProviderGetFilteringRuleMonitorCreateDataProvider() {
        FilteringRuleMonitorCreateTestData filteringRuleMonitorCreateTestData = new FilteringRuleMonitorCreateTestData();
        return filteringRuleMonitorCreateTestData.genFilteringRuleMonitorCreateTestData();
    }


    @Test(dataProvider = "dataPrdGetFilteringRuleMonitorCreateTest")
    public void testGetFilteringRuleMonitorCreateTest(String caseName, FilteringRuleMonitorCreateRequestBean filteringRuleMonitorCreateRequestBean, EnumCode enumCode) {

        logger.info("--------------" + caseName + " start--------------");
        String responseString = new PolicyMonitorAppCaller().getFilteringRuleMonitorCreate(filteringRuleMonitorCreateRequestBean);
        BaseRes loginResponse = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(loginResponse.getCode(), enumCode.getCode());
        Assert.assertEquals(loginResponse.getMsg(), enumCode.getMsg());
        logger.info("--------------" + caseName + " end--------------");
    }
}
