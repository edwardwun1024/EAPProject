package com.edward.app.person;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.PersonAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.person.PersonAddMemberToGroupsTestData;
import com.edward.requestbean.person.bean.PersonAddMemberToGroupsRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * url：/PERSON/member/addMemberToGroups
 * 功能：加人到多个组中
 * @author wangcheng
 * @date 2020/6/3 18:39
 */
public class PersonAddMemberToGroupsTest extends BaseApiTest {
    @DataProvider(name = "getPersonAddMemberToGroupsDataProvider")
    public Object[][] getDataProvidergetPersonAddMemberToGroupsDataProvider( ){
        PersonAddMemberToGroupsTestData personAddMemberToGroupsTestData = new PersonAddMemberToGroupsTestData();
        return personAddMemberToGroupsTestData.genPersonAddMemberToGroupsTestData();
    }


    @Test(dataProvider = "getPersonAddMemberToGroupsDataProvider")
    public void testGetPersonAddMemberToGroupsTest(String caseName, PersonAddMemberToGroupsRequestBean personAddMemberToGroupsRequestBean, EnumCode enumCode){
        logger.info("--------------"+caseName+" start--------------");
        String responseString = new PersonAppCaller().getPostPersonAddMemberToGroups(personAddMemberToGroupsRequestBean);
        BaseRes baseRes = gson.fromJson(responseString,BaseRes.class);
        Assert.assertEquals(baseRes.getCode(),enumCode.getCode());
        Assert.assertEquals(baseRes.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
