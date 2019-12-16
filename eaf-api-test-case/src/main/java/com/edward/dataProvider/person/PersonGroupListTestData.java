package com.edward.dataProvider.person;


import com.edward.requestbean.person.PersonGroupListRequestBean;

public class PersonGroupListTestData {

    public Object[][] genPersonGroupListTestData(){
        PersonGroupListRequestBean personGroupListRequestBean = new PersonGroupListRequestBean();
        personGroupListRequestBean.setCurrent("1");
        personGroupListRequestBean.setSize("10");
        personGroupListRequestBean.setCnName("wc-TestGroup");
        personGroupListRequestBean.setGroupId("");

        return new Object[][]{
                {"获取组得list",personGroupListRequestBean,"responseCode"}
        };
    }

}
