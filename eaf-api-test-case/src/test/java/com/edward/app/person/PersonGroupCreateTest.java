package com.edward.app.person;

import com.edward.Base.BaseApiTest;
import com.edward.appcaller.PersonAppCaller;
import com.edward.common.EnumCode;
import com.edward.dataProvider.person.PersonGroupCreateTestData;
import com.edward.requestbean.person.bean.PersonGroupCreateRequestBean;
import com.edward.responsebean.basic.BaseRes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wangcheng
 * @date 2020/6/4 10:56
 */
public class PersonGroupCreateTest  extends BaseApiTest {
    @DataProvider(name = "getPersonGroupCreateDataProvider")
    public Object[][] getDataProviderPersonGroupCreateDataProvider( ){
        PersonGroupCreateTestData personGroupCreateTestData = new PersonGroupCreateTestData();
        return personGroupCreateTestData.genPersonGroupCreateTestData();
    }


    @Test(dataProvider = "getPersonGroupCreateDataProvider")
    public void testGetPersonGroupCreateTest(String caseName, PersonGroupCreateRequestBean personGroupCreateRequestBean, EnumCode enumCode){
        logger.info("--------------"+caseName+" start--------------");
        String responseString = new PersonAppCaller().getPostPersonPersonGroupCreate(personGroupCreateRequestBean);
        BaseRes baseRes = gson.fromJson(responseString,BaseRes.class);
        Assert.assertEquals(baseRes.getCode(),enumCode.getCode());
        Assert.assertEquals(baseRes.getMsg(),enumCode.getMsg());
        logger.info("--------------"+caseName+" end--------------");
    }
}
