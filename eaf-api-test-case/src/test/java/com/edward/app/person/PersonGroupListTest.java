package com.edward.app.person;


import com.edward.Base.BaseApiTest;
import com.edward.appcaller.PersonAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.person.PersonGroupListTestData;
import com.edward.requestbean.person.bean.PersonGroupListRequestBean;
import com.edward.responsebean.basic.PageRes;
import com.edward.responsebean.person.PersonGroupListRes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * url:/PERSON/personGroup/list
 * service: person
 * 功能：获取groupId
 * created by : 王诚
 */
public class PersonGroupListTest extends BaseApiTest {

    @DataProvider(name = "getPersonGroupListDataProvider")
    public Object[][] getDataProviderPersonGroupListDataProvider() {
        PersonGroupListTestData personGroupListTestData = new PersonGroupListTestData();
        return personGroupListTestData.genPersonGroupListTestData();
    }


    @Test(dataProvider = "getPersonGroupListDataProvider")
    public void testGetPersonGroupListTest(String caseName, PersonGroupListRequestBean personGroupListRequestBean, EnumCode enumCode) {
        logger.info("--------------" + caseName + " start--------------");
        String responseString = new PersonAppCaller().getPostPersonGroupList(personGroupListRequestBean);
        PageRes<PersonGroupListRes> pageRes = new Gson().fromJson(responseString, new TypeToken<PageRes<PersonGroupListRes>>() {
        }.getType());
        Assert.assertEquals(pageRes.getCode(), enumCode.getCode());
        Assert.assertEquals(pageRes.getMsg(), enumCode.getMsg());
        logger.info("--------------" + caseName + " end--------------");
    }
}
