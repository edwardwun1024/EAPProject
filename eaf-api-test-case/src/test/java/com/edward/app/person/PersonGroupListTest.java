package com.edward.app.person;


import com.edward.appcaller.PersonAppCaller;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.edward.dataProvider.person.PersonGroupListTestData;
import com.edward.http.common.Utils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.edward.requestbean.person.bean.PersonGroupListRequestBean;
import com.edward.responsebean.person.PageRes;
import com.edward.responsebean.person.PersonGroupListRes;

/**
 * url:/PERSON/personGroup/list
 * service: person
 * created by : 王诚
 */
public class PersonGroupListTest {

    @DataProvider(name = "getPersonGroupListDataProvider")
    public Object[][] getDataProviderPersonGroupListDataProvider( ){
        //通过context.class 获取PersonGroupListTestData.genPersonGroupListTestData
        PersonGroupListTestData personGroupListTestData = new PersonGroupListTestData();
        return personGroupListTestData.genPersonGroupListTestData();
    }

    //获取groupId
    @Test(dataProvider = "getPersonGroupListDataProvider")
    public void testGetPersonGroupListTest(String caseName, PersonGroupListRequestBean personGroupListRequestBean, String httpResponseCode){
        Utils.info("--------------"+caseName+" start--------------");
        String responseString = new PersonAppCaller().getPostPersonGroupList(personGroupListRequestBean);
        PageRes<PersonGroupListRes> pageRes = new Gson().fromJson(responseString,PageRes.class);
        Utils.info("response:"+ JSON.toJSONString(pageRes));

        Utils.info("--------------"+caseName+" end--------------");
    }
}
