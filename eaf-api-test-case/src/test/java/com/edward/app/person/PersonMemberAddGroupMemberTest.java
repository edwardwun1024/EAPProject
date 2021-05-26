package com.edward.app.person;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.PersonAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.person.PersonMemberAddGroupMemberTestData;
import com.edward.requestbean.person.bean.PersonMemberAddGroupMemberRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2020/6/4 18:11
 */
public class PersonMemberAddGroupMemberTest extends BaseApiTest {
    @DataProvider(name = "getPersonMemberAddGroupMemberTestDataProvider")
    public Object[][] getDataProviderPersonMemberAddGroupMemberTestDataProvider() {
        PersonMemberAddGroupMemberTestData personMemberAddGroupMemberTestData = new PersonMemberAddGroupMemberTestData();
        return personMemberAddGroupMemberTestData.genPersonMemberAddGroupMemberTestData();
    }


    @Test(dataProvider = "getPersonMemberAddGroupMemberTestDataProvider")
    public void testGetPersonMemberAddGroupMemberTest(String caseName, PersonMemberAddGroupMemberRequestBean personMemberAddGroupMemberRequestBean, EnumCode enumCode) {
        logger.info("--------------" + caseName + " start--------------");
        String responseString = new PersonAppCaller().getPostPersonMemberAddGroupMember(personMemberAddGroupMemberRequestBean);
        BaseRes baseRes = gson.fromJson(responseString, BaseRes.class);
        Assert.assertEquals(baseRes.getCode(), enumCode.getCode());
        Assert.assertEquals(baseRes.getMsg(), enumCode.getMsg());
        logger.info("--------------" + caseName + " end--------------");
    }
}
