package com.edward.app.person;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.PersonAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.person.PersonCreateTestData;
import com.edward.requestbean.person.bean.PersonCreateRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * url:/PERSON/person/create
 * 功能：创建person
 * @author wangcheng
 * @date 2020/6/3 18:39
 */
public class PersonCreateTest extends BaseApiTest {

    @DataProvider(name = "getPersonCreateDataProvider")
    public Object[][] getDataProviderPersonGroupListDataProvider( ){
        PersonCreateTestData personCreateTestData = new PersonCreateTestData();
        return personCreateTestData.genPersonCreateTestData();
    }


    @Test(dataProvider = "getPersonCreateDataProvider")
    public void testGetPersonCreateTest(String caseName, PersonCreateRequestBean personCreateRequestBean, EnumCode enumCode){
        logger.info("--------------"+caseName+" start--------------");
        String responseString = new PersonAppCaller().getPostPersonCreate(personCreateRequestBean);
        BaseRes baseRes = gson.fromJson(responseString,BaseRes.class);
        Assert.assertEquals(baseRes.getCode(),enumCode.getCode());
        Assert.assertEquals(baseRes.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
